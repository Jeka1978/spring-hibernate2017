package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //50 lines of code
        return "<html> don't call us we call you</html>";
    }

    @Override
    public int myCode() {
        return 2;
    }
}
