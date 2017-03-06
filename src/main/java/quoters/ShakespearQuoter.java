package quoters;

import lombok.Setter;
import mySpring.Benchmark;
import mySpring.InjectRandomInt;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class ShakespearQuoter implements Quoter {
    @InjectRandomInt(min = 3,max = 6)
    private int repeat;


    @PostConstruct
    public void init(){
        System.out.println("repeat = " + repeat);
    }

    @Setter
    private String message;
    @Override
    @Benchmark
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }


}
