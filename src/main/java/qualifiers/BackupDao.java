package qualifiers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Repository
@Oracle
public class BackupDao implements Dao {
    @Override
    @SneakyThrows
    public void save() {
        Thread.sleep(500);
        System.out.println("saving to ORACLE");
    }
}
