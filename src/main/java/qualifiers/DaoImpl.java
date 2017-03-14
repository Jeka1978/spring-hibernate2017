package qualifiers;

import org.springframework.stereotype.Repository;

import static qualifiers.DBType.MONGO;

/**
 * Created by Evegeny on 14/03/2017.
 */
@NiceRepo(MONGO)
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("saving to mongo...");
    }
}
