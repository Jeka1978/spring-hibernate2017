package orm.learning.dao;

import lombok.Setter;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import orm.learning.model.Person;

import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Service
@Transactional(timeout = 1000)
@Setter
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao dao;

    public void updatePerson(Person person) {
        dao.updatePerson(person);
    }

    @Override
    public List<Person> getAdultPersons() {
        return dao.getPersonsAboveAge(18);
    }

    @Transactional(timeout = 2000)
    public void savePerson(Person person) {
        dao.savePerson(person);
    }

    public List<Person> getPersons() {
        return dao.getPersons();
    }
}
