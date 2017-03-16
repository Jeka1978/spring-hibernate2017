package bookstore.dao;

import bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
public interface BookDao extends CrudRepository<Book,Long> {
    List<Book> findByPriceLessThan(int price);
}
