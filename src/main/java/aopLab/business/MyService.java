package aopLab.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Service
public class MyService {
    @Autowired
    private Dao dao;

    public void doWork() {
        System.out.println("Working...");
        dao.save();
    }
}
