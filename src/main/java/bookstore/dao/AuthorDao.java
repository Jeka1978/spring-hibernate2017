package bookstore.dao;

import bookstore.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
public interface AuthorDao extends CrudRepository<Author,Long> {


    @Query()
    List<Author> findPleeeeaseByBooksPriceLessThan(int price);
}
