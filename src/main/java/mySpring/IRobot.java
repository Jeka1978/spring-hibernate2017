package mySpring;

import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 01/03/2017.
 */
@Benchmark
public class IRobot {
    @InjectByType
    @Setter
    private Speaker speaker;
    @InjectByType
    @Setter
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        System.out.println(cleaner.getClass());
    }

    @Scheduled(cron = "0 1/5 * * * FRI")
    public void cleanRoom() {
        speaker.speak("I started to clean the room");
        cleaner.clean();
        speaker.speak("I finished to clean the room");
    }
}
