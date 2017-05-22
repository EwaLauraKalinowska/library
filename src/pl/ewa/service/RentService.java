package pl.ewa.service;

import pl.ewa.model.Book;
import pl.ewa.model.Rent;
import pl.ewa.model.User;

import java.util.List;

/**
 * Created by ewcia on 28.04.17.
 */
public interface RentService {
    void createRent(User user, Book book);
    List<Rent> findAll();
    List<Rent> findByUserOrderByCratedDateDesc(User user);
}
