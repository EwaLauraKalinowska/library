package pl.ewa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ewa.dao.BookDao;
import pl.ewa.dao.RentDao;
import pl.ewa.model.Book;
import pl.ewa.model.Rent;
import pl.ewa.model.User;

import java.util.List;

/**
 * Created by ewcia on 28.04.17.
 */
@Service
public class RentServiceImp implements RentService{

    @Autowired
    private BookDao bookDao;

    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public void createRent(User user, Book book) {
        Rent rent= new Rent(user, book);
        rentDao.save(rent);
        book.decrementAvailable();
        bookDao.save(book);
    }

    @Override
    public List<Rent> findAll() {
        return rentDao.findAll();
    }

    @Override
    public List<Rent> findByUserOrderByCratedDateDesc(User user) {
        return rentDao.findByUserOrderByCreatedDateDesc(user);
    }
}
