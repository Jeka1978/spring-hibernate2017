package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class BenchmarkPowerCleaner implements Cleaner {
    @InjectByType
    private PowerCleaner powerCleaner;

    public void clean() {
        long start = System.nanoTime();
        powerCleaner.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}
