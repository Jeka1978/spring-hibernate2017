package orm.learning.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import orm.learning.model.Person;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 16/03/2017.
 */
public class PersonServiceImplTest {

    private List<Person> mockPersons;

    @Before
    public void setUp() throws Exception {
        mockPersons = Arrays.asList(new Person(1, 12, "Moshe"));

    }

    @Test
    public void savePerson() throws Exception {
        PersonServiceImpl service = new PersonServiceImpl();
        PersonDao personDaoMock = Mockito.mock(PersonDao.class);
        Mockito.when(personDaoMock.getPersons()).thenReturn(mockPersons);
        service.setDao(personDaoMock);
        List<Person> persons = service.getPersons();
        Assert.assertEquals(1,persons.get(0).getId());
    }

}









