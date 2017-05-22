package pl.ewa.service;

import pl.ewa.model.Book;

import java.util.List;

/**
 * Created by ewcia on 25.04.17.
 */


public interface BookService {

    List<Book> findAll();
    Book findBook(Long id);
    void save(Book book);
    void delete(Long id);
}
