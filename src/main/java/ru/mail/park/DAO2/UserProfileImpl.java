package ru.mail.park.DAO2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ru.mail.park.model.UserProfile;

@Repository
public class UserProfileImpl implements UserProfileDAO {

  @PersistenceContext
  private EntityManager entityManager;

  public UserProfile getUserById(Integer id) {
    return entityManager.find(UserProfile.class, id);
  }

  public Integer addNewUser(String login, String name, String password, String email) {
    UserProfile user = new UserProfile(login, name, email, password);
    entityManager.persist(user);
    return user.getId();
  }

  public UserProfile existingUserByLogin(String login) {

    return entityManager
        .createQuery("select u from UserProfile u"
            + " where u.login=:login", UserProfile.class)
        .setParameter("login", login)
        .getSingleResult();

  }

  public List<UserProfile> getAllUsers() {

    // TODO надо как-то ограничить результат и никогда не доставать всех
    return entityManager
        .createQuery("select u from UserProfile u", UserProfile.class)
        .getResultList();

  }

  public Boolean removeUser(Integer id) {
    UserProfile entity = entityManager.find(UserProfile.class, id);
    if (entity == null) {
      return false;
    } else {
      entityManager.remove(entity);
      return true;
    }

  }

}
