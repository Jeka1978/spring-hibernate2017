package chainOfResponsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
@Order(10)
public class MosheForbiddenValidator implements Validator {
    @Override
    public String validate(Person person) {
        if (person.getName().equalsIgnoreCase("MOSHE")) {
            return "You can't be Moshe";
        }
        return "";
    }
}
