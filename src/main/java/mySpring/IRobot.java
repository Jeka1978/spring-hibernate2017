package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class IRobot {
    private Speaker speaker = new ConsoleSpeaker();
    private Cleaner cleaner = new CleanerImpl();

    public void cleanRoom() {
        speaker.speak("I started to clean the room");
        cleaner.clean();
        speaker.speak("I finished to clean the room");
    }
}
