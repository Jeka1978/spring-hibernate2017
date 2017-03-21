package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Builder;
import lombok.experimental.*;

import java.util.List;

/**
 * Created by Evegeny on 21/03/2017.
 */

@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
public class User {

    @lombok.experimental.Delegate(excludes = PersonExclude.class)
    private Person person = new Person();

    @Singular
    @Getter
    private List<String> favorites;

    @JsonIgnore
    public void setId(int id) {
        this.person.setId(id);
    }


}
