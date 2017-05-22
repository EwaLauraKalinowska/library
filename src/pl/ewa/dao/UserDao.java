package pl.ewa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ewa.model.User;

/**
 * Created by ewcia on 25.04.17.
 */

@Repository
public interface UserDao extends JpaRepository <User, Long>{


    User findByEmail(String email);
}
