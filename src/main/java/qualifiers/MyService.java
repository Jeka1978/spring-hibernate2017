package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Service
@EnableScheduling
public class MyService {
    @Autowired
    @Oracle
    private Dao backupDao;

    @Autowired
    @Mongo
    private Dao dao;

    @Scheduled(cron = "1/1 * * * * ?")
    public void doWork() {
        dao.save();
    }

    @Scheduled(cron = "1/3 * * * * ?")
    public void doBackup() {
        backupDao.save();
    }

}














