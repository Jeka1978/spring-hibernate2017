package model;

import lombok.*;
import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 21/03/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class User {

    @Delegate
    private Person person = new Person();
    @Singular
    @Getter
    private List<String> favorites = new ArrayList<>();
}
