package quoters;

import lombok.Setter;

import java.util.List;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class TalkingRobotImpl implements TalkingRobot {
    @Setter
    private List<Quoter> quoters;
    @Override
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}
