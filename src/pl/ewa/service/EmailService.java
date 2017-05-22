package pl.ewa.service;

/**
 * Created by ewcia on 05.05.17.
 */
public interface EmailService {
    void sendEmail(String fromAddress, String toAddress, String subject, String body);
}
