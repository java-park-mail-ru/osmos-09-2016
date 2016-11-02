package ru.mail.park.DAO2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ru.mail.park.model.UserForResponse;
import ru.mail.park.model.UserProfile;

@Repository
public class UserRequestsImpl implements UserRequestsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserProfile getUserById(Long id) {
        return entityManager.find(UserProfile.class, id);
    }

    public Long addNewUser(String login, String name, String password, String email) {
        UserProfile user = new UserProfile(login, name, email, password);
        entityManager.persist(user);
        return user.getId();
    }

    public UserProfile existingUserByLogin(String login) {
        UserProfile user = null;
        try {
            user = entityManager
                    .createQuery("select u from UserProfile u"
                            + " where u.login=:login", UserProfile.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException nre) {

        }
        return user;

    }


    public List<UserForResponse> getAllUsers() {

        List<UserForResponse> users = null;
        // TODO надо как-то ограничить результат и никогда не доставать всех
        try {
            Query query = entityManager
                    .createQuery("select u from UserForResponse u");
            users = query.setMaxResults(50).getResultList();
        } catch (NoResultException nre) {

        }

        return users;
    }

    public Boolean removeUser(Long id) {
        UserProfile entity = entityManager.find(UserProfile.class, id);
        if (entity == null) {
            return false;
        } else {
            entityManager.remove(entity);
            return true;
        }

    }

}
