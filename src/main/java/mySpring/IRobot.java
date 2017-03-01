package mySpring;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 01/03/2017.
 */
@Benchmark
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started to clean the room");
        cleaner.clean();
        speaker.speak("I finished to clean the room");
    }
}
