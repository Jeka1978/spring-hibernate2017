package orm.learning.dao;

import orm.learning.model.Person;

import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
public interface PersonDao {
    void savePerson(Person person);

    List<Person> getPersons();

    void updatePerson(Person person);

    List<Person> getPersonsAboveAge(int age);
}
