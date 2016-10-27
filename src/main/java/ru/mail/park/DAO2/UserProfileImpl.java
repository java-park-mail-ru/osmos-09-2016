package ru.mail.park.DAO2;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.mail.park.model.UserProfile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserProfileImpl implements UserProfileDAO {


    public UserProfile getUserById(Integer id) {
        Session session = null;
        UserProfile userProfile = null;
        try {
            session = HabernateUtil.getSessionFactory().openSession();
            userProfile = (UserProfile) session.load(UserProfile.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userProfile;
    }

    public Integer addNewUser(String login, String name, String password, String email) {

        UserProfile user = new UserProfile(login, name, email, password);
        Session session = null;
        try {
            session = HabernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return user.getId();
    }


    public UserProfile existingUserByLogin(String login) {

        List<UserProfile> users = null;
        Session session = null;
        try {
            session = HabernateUtil.getSessionFactory().openSession();
//            userProfile = (UserProfile) session.load(UserProfile.class, login);
            Criteria criteria = session.createCriteria(UserProfile.class);
            criteria.add(Restrictions.eq("login", login));
            users = criteria.list();
//            Query query=session.createQuery("from UserProfile where login =:username");
//            query.setString("username", login);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return users.get(0);
    }


    public List<UserProfile> getAllUsers() {
        Session session = null;
        List users = new ArrayList<UserProfile>();
        try {
            session = HabernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(UserProfile.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public Integer addNewSeesion(UserProfile user) {

        return 1;
    }


    public Boolean removeUser(Integer id) {
        UserProfile userProfile = getUserById(id);
        Session session = null;
        try {
            session = HabernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(userProfile);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

}
