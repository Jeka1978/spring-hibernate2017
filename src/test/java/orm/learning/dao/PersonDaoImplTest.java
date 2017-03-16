package orm.learning.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import orm.learning.DBConfig;
import orm.learning.model.Person;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 16/03/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@Transactional
public class PersonDaoImplTest {
    @Autowired
    private PersonDao personDao;
    @Test

//    @Rollback(false)
    public void savePersonAndGetPersons() throws Exception {
        personDao.savePerson(new Person("Moshe",120));
        List<Person> persons = personDao.getPersons();
        System.out.println("persons = " + persons);
    }

    @Test
    public void getPersonsAboveAge() {
        List<Person> persons = Arrays.asList(new Person("Moshe", 8)
                , new Person("Hila", 28)
                , new Person("Aron", 38));
        for (Person person : persons) {
            personDao.savePerson(person);
        }
        List<Person> personList = personDao.getPersonsAboveAge(10);
        Assert.assertEquals(2,personList.size());
    }

}