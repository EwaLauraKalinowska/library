package pl.ewa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.ewa.dao.UserDao;
import pl.ewa.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewcia on 05.05.17.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(userDao.findOne(id));

    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userDao.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException(String.format("%s nie istnieje w bazie danych!", email));
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ user.getUser_role()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
