package bookstore.dao;

import bookstore.BookStoreConfig;
import bookstore.model.Author;
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
public class AuthorDaoTest {
    @Autowired
    private AuthorDao authorDao;
    @Test
    public void findPleeeeaseByBooksPriceLessThan() throws Exception {
        System.out.println(authorDao.getClass().getName());
        Author jack = Author.builder()
                .name("Jack London")
                .book(new Book("White Dog", 40))
                .book(new Book("Black Dog", 60)).build();

        Author tolkien = Author.builder()
                .name("Tolkien")
                .book(new Book("Lord", 35))
                .book(new Book("Silmarillion", 600)).build();

        authorDao.save(tolkien);
        authorDao.save(jack);

        authorDao.findPleeeeaseByBooksPriceLessThan(39).forEach(System.out::println);

    }

}