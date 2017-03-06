package quoters;

import java.util.List;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class TerminatorQuoter implements Quoter {
    private List<String> message;

    @Override
    public void sayQuote() {
        message.forEach(System.out::println);
    }
}
