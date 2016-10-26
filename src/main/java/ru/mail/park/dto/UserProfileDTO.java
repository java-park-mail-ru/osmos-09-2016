package ru.mail.park.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import ru.mail.park.model.UserProfile;

/**
 * Created by SergeyCheremisin on 23/10/2016.
 */
public class UserProfileDTO {
    @NotEmpty
//    @Length(max = UserProfile.MAX_LENGTH_LOGIN)
    private String login;

    @NotEmpty
//    @Length(max = UserProfile.MAX_LENGTH_EMAIL)
    private String email;
    @NotEmpty
//    @Length(max = UserProfile.MAX_LENGTH_PASSWORD)
    private String password;


    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
