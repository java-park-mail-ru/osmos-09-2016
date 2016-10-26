package ru.mail.park.model;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;

/**
 * Created by SergeyCheremisin on 22/09/16.
 */
//@Component
//@Scope("session")
@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Login"),
        @UniqueConstraint(columnNames = "Email") })
public class UserProfile {

//    public static final int MAX_LENGTH_LOGIN = 200;
//    public static final int MAX_LENGTH_EMAIL = 100;
//    public static final int MAX_LENGTH_PASSWORD = 100;

    @Id
    @Column(name = "User_id")
    @GeneratedValue
    private Integer id;

    @NotEmpty
//    @Length(max = UserProfile.MAX_LENGTH_LOGIN)
    @Column(name = "Login")
    private String login;

    @Column(name = "Name")
    private String name;

    @NotEmpty
//    @Length(max = UserProfile.MAX_LENGTH_EMAIL)
    @Column(name = "Email")
    private String email;
    @NotEmpty
//    @Length(max = UserProfile.MAX_LENGTH_PASSWORD)
    @Column(name = "Password")
    private String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public UserProfile(String login, String name, String email, String password) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserProfile() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
