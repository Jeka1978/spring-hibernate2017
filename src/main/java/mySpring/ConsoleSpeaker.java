package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
@Benchmark
public class ConsoleSpeaker implements Speaker {

    public void scream(String message) {
        System.out.println(message.toUpperCase());
    }
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
