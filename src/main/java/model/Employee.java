package model;

import lombok.Data;
import lombok.experimental.Delegate;

/**
 * Created by Evegeny on 21/03/2017.
 */
@Data
public class Employee {
    @Delegate
    private Person person;

    private int salary;
}
