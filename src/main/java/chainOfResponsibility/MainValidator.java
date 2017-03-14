package chainOfResponsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Service
public class MainValidator {
    @Autowired
    private List<Validator> validators;

    public void printErrors(Person person) {
        StringBuilder errors = new StringBuilder();
        for (Validator validator : validators) {
            errors.append(validator.validate(person)).append("\n");
        }
        System.out.println(errors.toString());
    }
}
