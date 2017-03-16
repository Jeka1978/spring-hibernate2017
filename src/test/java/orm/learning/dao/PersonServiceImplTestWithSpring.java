package orm.learning.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import orm.learning.DBConfig;
import orm.learning.model.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DBConfig.class)
public class PersonServiceImplTestWithSpring {

    @Autowired
    private PersonService service;

    @Test
    public void savePerson() throws Exception {
        service.savePerson(new Person("Moshe",120));
        List<Person> persons = service.getPersons();
        Assert.assertEquals(1,persons.get(0).getId());
    }

}









