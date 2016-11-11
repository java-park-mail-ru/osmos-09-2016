package ru.mail.park.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.park.DAO2.UserRequestsDAO;
import ru.mail.park.model.UserProfile;


@Transactional
@Service
public class AccountService {

    @Autowired
    private UserRequestsDAO userDao;

    public List<UserProfile> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserProfile getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    public boolean removeUserById(Long id) {
        return this.userDao.removeUser(id);
    }

    public UserProfile duplicateEmail(String email){
        return userDao.duplicateEmail(email);
    }

    public UserProfile existingUserByLogin(String user) {

        return userDao.existingUserByLogin(user);
    }

    public Long addUser(String login, String name, String password, String email) {
        return userDao.addNewUser(login, name, password, email);
    }

}
