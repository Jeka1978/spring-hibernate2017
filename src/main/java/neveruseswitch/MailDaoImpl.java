package neveruseswitch;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Repository
public class MailDaoImpl implements MailDao {
    @Override
    public int getMailCode() {
        Random random = new Random();
        return random.nextInt(3)+1;
    }
}
