package animals;

import lombok.*;

import java.util.List;

/**
 * Created by Evegeny on 01/03/2017.
 */
@AllArgsConstructor
//@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "age")
@ToString(exclude = "firstName")
@Getter
public class Person {
    private String firstName;
    @Setter
    private int age;
//    @Singular("oneFish")
    @Singular
    private List<String> professions;
}
