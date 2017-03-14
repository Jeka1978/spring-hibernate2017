package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Service
public class MailSender {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    @Autowired
    private MailDao dao;


    @Autowired
    public MailSender(List<MailGenerator> mailGenerators) {
        for (MailGenerator mailGenerator : mailGenerators) {
            if (map.containsKey(mailGenerator.myCode())) {
                throw new RuntimeException("mailcode " + mailGenerator.myCode() + " already used");
            }
            map.put(mailGenerator.myCode(), mailGenerator);
        }
    }

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        int code = dao.getMailCode();
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




