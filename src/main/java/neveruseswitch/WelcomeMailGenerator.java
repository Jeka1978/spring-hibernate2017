package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //50 lines of code
        return "<html> Welcome new Client</html>";
    }
}
