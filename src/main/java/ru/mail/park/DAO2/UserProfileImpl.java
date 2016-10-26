package ru.mail.park.DAO2;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.park.model.UserProfile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SergeyCheremisin on 25/10/2016.
 */
@Repository
public class UserProfileImpl implements UserProfileDAO {


    public Integer getUserById(Integer id) {
        return 1;
    }

    public Integer addNewUser(String login, String password, String email){

        String name = "Ivan";
        UserProfile user = new UserProfile(login, name, email, password);
        Session session = null;
        try{
            session = HabernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //session.save(user);
            session.getTransaction().commit();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        }finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return user.getId();
    }

    public List<UserProfile> getAllUsers(){
       List<UserProfile> ddd = new ArrayList<UserProfile>();

        return ddd;
    }

    public Integer addNewSeesion(UserProfile user){

        return 1;
    }

    public Integer removeUser(String login){

        return 1;
    }


}
