package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
