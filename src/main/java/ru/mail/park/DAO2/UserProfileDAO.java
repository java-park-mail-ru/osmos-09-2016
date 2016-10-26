package ru.mail.park.DAO2;

import ru.mail.park.model.UserProfile;

import java.util.List;

/**
 * Created by SergeyCheremisin on 25/10/2016.
 */
public interface UserProfileDAO {

    public Integer addNewUser(String login, String email, String password);

    public List<UserProfile> getAllUsers();

    public UserProfile existingUserByLogin(String login);

    public UserProfile getUserById(Integer id);

    public Integer addNewSeesion(UserProfile user);

    public Boolean removeUser(Integer id);

}
