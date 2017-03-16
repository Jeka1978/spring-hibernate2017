package bookstore.services;

import bookstore.BookStoreConfig;
import bookstore.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 16/03/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BookStoreConfig.class)
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void saveBook() throws Exception {
        bookService.saveBook(new Book("Lord of the Spring",120),
                new Book("Hobbit",50));
//        Iterable<Book> allBooks = bookService.getAllBooks();
//        allBooks.forEach(System.out::println);

     bookService.findCheapBooks().forEach(System.out::println);
    }

}