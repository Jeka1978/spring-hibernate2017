package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
public class Starter {
    @Autowired
    private ColorFrame colorFrame;

    @Scheduled(fixedRate = 80)
    public void moveFrame(){
        colorFrame.fly();
    }
}
