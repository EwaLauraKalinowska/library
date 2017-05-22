package pl.ewa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ewa.model.Rent;
import pl.ewa.model.User;

import java.util.List;

/**
 * Created by ewcia on 25.04.17.
 */

@Repository
public interface RentDao extends JpaRepository<Rent, Long>{

    List<Rent> findByUserOrderByCreatedDateDesc(User user);
}
