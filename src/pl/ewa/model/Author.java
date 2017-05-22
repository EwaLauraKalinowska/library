package pl.ewa.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ewcia on 21.04.17.
 */
public class Author extends BaseEntity {

    @Size(min=2, max=100, message = "Za długie lub za krótkie imie!")
    @NotNull
    String name;

    @Size(min=2, max=100, message = "Za długie lub za krótkie nazwisko!")
    @NotNull
    String surname;


    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
