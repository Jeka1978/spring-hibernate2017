package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 06/03/2017.
 */
@Component
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Value("${terminator}")
    public void initMessages(String message, @Value("JAVA_HOME") String javaHome) {
        this.messages = Arrays.asList(message.split(","));
        System.out.println("javaHome = " + javaHome);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

    public void killAll(){
        System.out.println("You are teminated....");
    }
}
