package pl.ewa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ewcia on 24.04.17.
 */
@Entity
@Table(name = "rent")
public class Rent {

    public enum Status{
        IN_PROGRESS, FINISHED
    }

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch =FetchType.EAGER )
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Rent() {
    }

    public Rent(User user, Book book) {
        createdDate = new Date();
        this.status = Status.IN_PROGRESS;
        this.user = user;
        this.book = book;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
