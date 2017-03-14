package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Service
public class MailSender {

    @Autowired
    private MailDao dao;

    public void sendMail() {
        int code = dao.getMailCode();
        switch (code) {
            case 1:
                //50 lines of code
                System.out.println("welcome mail was sent");
                break;
            default:
                // 40 lines of code
                System.out.println("don't call us we call you was sent");
                break;
        }
    }
}
