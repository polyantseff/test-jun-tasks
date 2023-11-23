package jun.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

//@Entity
//@Data
////@Table(appliesTo = "User")
////@ToString(of ={"id","name"})
@EqualsAndHashCode(of={"id"})
//@ComponentScan(basePackages = "jun")
@Entity
@Table(appliesTo = "pet_user")
@ToString(of = {"id","name"})

public class User {
//    @javax.persistence.Id
//@javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}