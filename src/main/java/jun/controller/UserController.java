package jun.controller;

import jun.controller.exceptions.NotFoundException;
import jun.domain.User;
import jun.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

        public List<Map<String,String>> users=new ArrayList<Map<String,String>>(){{
        add(new HashMap<String,String>(){
            {put("id","1");put("fio","Пупкин Ильяс Соломонович");}
//            {put("id","2");put("fio","f f f");}
        });
    }};
    @GetMapping
    public List<User> list()
    {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user)
    {
        return user;
    }

//    private Map<String, String> getUser(String id) {
//        return users.stream()
//                .filter(users -> users.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") User userFromDb,@RequestBody User user)
    {
        BeanUtils.copyProperties(user,userFromDb,"id");
        return userRepo.save(user);
//        Map<String, String> userFromDb=getUser(id);
//        userFromDb.putAll(users);
//        userFromDb.put("id",id);
//        return userFromDb;
    }

    @GetMapping
    public String main(Map<String,Object> model)
    {
        Iterable<User> users=userRepo.findAll();
        model.put("users",users);
        return "main";
    }
}