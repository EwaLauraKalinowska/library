package pl.ewa.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.ewa.model.User;
import pl.ewa.service.EmailService;
import pl.ewa.service.UserService;

import java.util.List;

/**
 * Created by ewcia on 20.04.17.
 */

@Service
public class AdvService {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    private final static String FROM_EMAIL="test123456789@gmail.com";

    @Scheduled(fixedDelay = 1000000)
    public void sendEmails(){
        List<User> listOfUsers=userService.findAll();

        if(listOfUsers==null){
            return;
        }
        for(User user: listOfUsers){
            emailService.sendEmail(FROM_EMAIL, user.getEmail(), "informacja z biblioteki", "Jesteśmy najlepsi! Wyporzycz u Nas książkę!");
        }

    }

}
