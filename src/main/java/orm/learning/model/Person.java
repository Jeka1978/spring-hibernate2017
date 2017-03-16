package orm.learning.model;

import com.sun.jndi.cosnaming.IiopUrl;
import lombok.*;
import orm.learning.QueriesConstants;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static orm.learning.QueriesConstants.GET_ALL_PERSONS;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Entity
@Table(name = "tbl_persons")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
        @NamedQuery(name = GET_ALL_PERSONS,query = "from Person"),
})

public class Person {

    @Id
    @GeneratedValue
    private int id;


    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    //    @Transient   if you don't want that this property will be synchronized with db
    private int age;

    private String name;
}
