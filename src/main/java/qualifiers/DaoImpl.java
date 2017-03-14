package qualifiers;

import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Repository
@Mongo
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("saving to Mongo...");
    }
}
