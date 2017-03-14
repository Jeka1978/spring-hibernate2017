package quoters;

import lombok.Setter;
import mySpring.Benchmark;
import mySpring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 06/03/2017.
 */
@Component
public class ShakespearQuoter implements Quoter {
    @InjectRandomInt(min = 3,max = 6)
    private int repeat;


    @Value("${shake}")
    private String message;

    @Override
    @Benchmark
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }


}
