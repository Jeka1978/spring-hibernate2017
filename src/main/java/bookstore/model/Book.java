package bookstore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@ToString
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
