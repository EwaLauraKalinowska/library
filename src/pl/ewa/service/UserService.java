package pl.ewa.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.ewa.model.User;

import java.util.List;

/**
 * Created by ewcia on 21.04.17.
 */
public interface UserService extends UserDetailsService {
    List<User> findAll();
    User findOne(Long id);
    void delete(Long id);
    void save(User user);
    User findByEmail(String email);
}
