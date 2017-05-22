package pl.ewa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ewa.dao.BookDao;
import pl.ewa.model.Book;

import java.util.List;

/**
 * Created by ewcia on 25.04.17.
 */
@Service
public class BookServiceImp implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findBook(Long id) {
        return bookDao.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void delete(Long id) {

        bookDao.delete(bookDao.findOne(id));
    }
}
