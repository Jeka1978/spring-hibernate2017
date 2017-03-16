package orm.learning.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import orm.learning.model.Person;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static orm.learning.QueriesConstants.GET_ALL_PERSONS;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> getPersons() {
//        List<Person> persons = entityManager.createQuery("from Person").getResultList();
        List<Person> persons = entityManager.createNamedQuery(GET_ALL_PERSONS).getResultList();
        return persons;
    }

    @Override
    public void updatePerson(Person person) {
        entityManager.merge(person);
        person.setAge(120);
    }

    @Override
    public List<Person> getPersonsAboveAge(int age) {
        Query query = entityManager.createQuery("from Person where age >:age");
//        query.setFirstResult(10).setMaxResults(5)
        query.setParameter("age", age);
//        CriteriaQuery<Object> criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
//        Root<Person> from = criteriaQuery.from(Person.class);
//        criteriaQuery.select(from)
//        Session delegate = (Session) entityManager.getDelegate();
        return query.getResultList();
    }
}





