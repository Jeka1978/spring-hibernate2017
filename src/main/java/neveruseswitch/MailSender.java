package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Service
public class MailSender {
    @Autowired
    private Map<String, MailGenerator> map;

    @Autowired
    private MailDao dao;

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        String code = String.valueOf(dao.getMailCode());
        MailGenerator mailGenerator = map.get(code);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(code + " not supported yet");
        }
        String html = mailGenerator.generateHtml();

        send(html);
    }

    private void send(String html) {
        System.out.println("sending... html = " + html);
    }
}




