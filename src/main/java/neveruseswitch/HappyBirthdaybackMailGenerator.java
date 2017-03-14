package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
public class HappyBirthdaybackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //70 lines of code
        return "<html> happy birthday</html>";
    }

    @Override
    public int myCode() {
        return 3;
    }
}
