package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component("3")
public class HappyBirthdaybackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //70 lines of code
        return "<html> happy birthday</html>";
    }
}
