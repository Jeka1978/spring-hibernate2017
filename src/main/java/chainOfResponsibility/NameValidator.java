package chainOfResponsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
@Order(1)
public class NameValidator implements Validator {
    @Override
    public String validate(Person person) {
        if (person.getName().equals(person.getName().toUpperCase())) {
            return "name can't be uppercased";
        }
        return "";
    }
}
