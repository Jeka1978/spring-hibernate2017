package quoters;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Evegeny on 06/03/2017.
 */

public class TalkingRobotImpl implements TalkingRobot {
    @Setter
    private List<Quoter> quoters;

    private List<StringBuilder> stringBuilders = new ArrayList<>();


    @Override
    @Scheduled(cron = "1/1 * * * * ?")
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
        for (int i = 0; i < 1_000_000; i++) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder("dsfsd" + random.nextInt(1000) + "sdfd");
            if (random.nextInt(100) == 1) {
                stringBuilders.add(sb);
            }

        }
    }
}





