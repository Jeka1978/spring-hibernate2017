package qualifiers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import static qualifiers.DBType.ORACLE;

/**
 * Created by Evegeny on 14/03/2017.
 */
@NiceRepo(ORACLE)
public class BackupDao implements Dao {
    @Override
    @SneakyThrows
    public void save() {
        Thread.sleep(500);
        System.out.println("saving to ORACLE");
    }
}
