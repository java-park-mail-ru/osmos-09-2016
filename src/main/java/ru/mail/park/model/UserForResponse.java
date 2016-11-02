package ru.mail.park.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "login"),
        @UniqueConstraint(columnNames = "email")})
public class UserForResponse {

    @Id
    @Column(name = "users_id")
    private Integer id;
    @NotEmpty
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String name;
    @NotEmpty
    @Column(name = "email")
    private String email;

    public UserForResponse() {

    }

    public UserForResponse(Integer id, String login, String name, String email) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public UserForResponse(String login, String name, String email) {
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {

        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
