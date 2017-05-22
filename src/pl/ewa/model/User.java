package pl.ewa.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * Created by ewcia on 21.04.17.
 */

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    public enum Role{
        ADMIN, USER
    }

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String surname;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private Role user_role=Role.USER;

    public User() {
    }

    public User(String name, String surname, String email, String password, Role user_role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.user_role = user_role;
    }
    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.user_role = Role.USER;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUser_role() {
        return user_role;
    }

    public void setUser_role(Role user_role) {
        this.user_role = user_role;
    }
}
