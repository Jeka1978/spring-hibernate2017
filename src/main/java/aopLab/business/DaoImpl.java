package aopLab.business;

import aopLab.DBException;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Repository
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("Saving...");
        closeTransaction();
        return;
    }

    private void closeTransaction() {
        throw new DBException("database is not working...");
    }
}
