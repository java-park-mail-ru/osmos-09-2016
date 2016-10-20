package ru.mail.park.FakeDB;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.mail.park.model.UserProfile;
import ru.mail.park.model.UserSession;

import java.util.*;

/**
 * Created by SergeyCheremisin on 26/09/16.
 */


@Repository
public class UserDao {

    private static Map<Integer, UserProfile> userProfiles;
    private Map<Integer, Integer> userSessions = new HashMap<Integer, Integer>();


    static {

        userProfiles = new HashMap<Integer, UserProfile>() {
            {
                put(0, new UserProfile("Sergey", "cheremisin.sergey@yandex.ru", "password11"));
                put(1, new UserProfile("Ilya", "nikitin.ilya@mail.ru", "password22"));
                put(2, new UserProfile("Ephrosiniya", "zerminova.phrosia@gmial.com", "password33"));
            }
        };
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "Return all users", required = true)
    public Collection<UserProfile> getAllUsers() {
        return userProfiles.values();
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "Return all user by id", required = true)
    public UserProfile getUserById(Integer id) {
        return userProfiles.get(id);
    }

    public boolean removeUserById(Integer id) {
//        if(userProfiles.remove(id) == null)
//            return true;

        return userProfiles.remove(id) == null;
    }

    public boolean existingUserById(Integer id) {
//        final UserProfile userProfile = userProfiles.get(id);
//        if(userProfile != null)
//            return true;
//        return false;
        return userProfiles.get(id) != null;
    }

    public UserProfile existingUserByLogin(String login) {
        for (Map.Entry<Integer, UserProfile> entry : userProfiles.entrySet()) {
            final Integer key = entry.getKey();
            final UserProfile value = entry.getValue();
            if (login.equals(value.getLogin())) {
                return value;
            }
        }
        return null;
    }

    public Integer addUser(String login, String password, String email) {
        final UserProfile userProfile = new UserProfile(login, email, password);
        final Random rn = new Random();
        for (int i = 0; i < userProfiles.size(); i++) {
            final Integer key = rn.nextInt(100);
            if (userProfiles.get(key) == null) {
                userProfiles.put(key, userProfile);
                return key;
            }
        }
        return 101;
    }


    public UserSession getIdUserIfExist(String login) {
        final UserSession session = new UserSession();
        for (Map.Entry<Integer, UserProfile> entry : userProfiles.entrySet()) {
            final Integer key = entry.getKey();
            final UserProfile value = entry.getValue();
            if (login.equals(value.getLogin())) {
                session.setIdUser(key);
                return session;
            }
        }
        return null;
    }


    public UserSession addSession(String login) {

        final UserSession session = getIdUserIfExist(login);
        if (session != null) {
            final Random rn = new Random();
            final Integer keySession = rn.nextInt(100);
            userSessions.put(keySession, session.getIdUser());
            session.setIdSession(keySession);
            return session;
        }

        return null;
    }


    public Collection getSessions() {
        return userSessions.values();
    }

    public boolean removeSessions(int id) {
        if (userSessions.containsKey(id)) {
            userSessions.remove(id);
            return true;
        }
        return false;
    }

}






