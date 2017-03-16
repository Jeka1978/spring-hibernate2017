package bookstore.services;

import bookstore.dao.BookDao;
import bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void saveBook(Book... books) {
        for (Book book : books) {
            bookDao.save(book);
        }
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findCheapBooks() {
        return bookDao.findByPriceLessThan(60);
    }
}
