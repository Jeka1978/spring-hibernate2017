package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
@Benchmark
public class PowerCleaner implements Cleaner {
    @InjectRandomInt(min = 3,max = 7)
    private int repeat;
    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FFFFFFFFFfffffffshhhhhhhh");
        }
    }
}
