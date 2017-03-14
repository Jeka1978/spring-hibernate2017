package quoters;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Evegeny on 06/03/2017.
 */
@Component
public class TalkingRobotImpl implements TalkingRobot {

    @Autowired
    private List<Quoter> quoters = Arrays.asList(new Quoter() {
        @Override
        public void sayQuote() {
            System.out.println("This is default quote");
        }
    });


    @Override
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }

    }
}





