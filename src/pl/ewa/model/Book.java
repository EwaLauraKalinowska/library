package pl.ewa.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ewcia on 21.04.17.
 */
@Entity
@Table(name ="books")
public class Book extends BaseEntity {

    @NotNull
    Author author;

    @NotNull
    @Size(min=2, max=120, message="Za krótki lub za długi tytuł")
    String title;


    @Min(0)
    private Integer available;

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(Author author, String title, Integer available) {
        this.author = author;
        this.title = title;
        this.available = available;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void decrementAvailable(){
        available--;
    }


}
