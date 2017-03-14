package chainOfResponsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
@Order(5)
public class AgeValidator implements Validator {

    @Override
    public String validate(Person person) {
        if (person.getAge() < 0) {
            return "age can't be negative";
        }
        return "";
    }
}
