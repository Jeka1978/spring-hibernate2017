package bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(cascade = ALL,fetch = FetchType.EAGER)
    @Singular
    private Set<Book> books;
















}
