package bookstore.services;

import bookstore.model.Book;

import java.util.List;

/**
 * Created by Evegeny on 16/03/2017.
 */
public interface BookService {

    void saveBook(Book... book);

    Iterable<Book> getAllBooks();

    List<Book> findCheapBooks();
}
