package quoters;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 06/03/2017.
 */

public class TalkingRobotImpl implements TalkingRobot {
    @Setter
    private List<Quoter> quoters;


    @Override
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}





