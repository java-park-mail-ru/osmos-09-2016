package ru.mail.park.Factory;

import ru.mail.park.DAO2.UserProfileImpl;
import ru.mail.park.DAO2.UserProfileDAO;

/**
 * Created by SergeyCheremisin on 25/10/2016.
 */
public class Factory {

    private static UserProfileDAO userProfielDAO = null;
    private static UserProfileImpl userProfileImpl = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public UserProfileDAO getUserDAO(){
        if(userProfielDAO == null){
            userProfielDAO = new UserProfileImpl();
        }
        return userProfielDAO;
    }

    public UserProfileImpl getUserProfileImpl(){
        if(userProfileImpl == null){
            userProfileImpl = new UserProfileImpl();
        }
        return userProfileImpl;
    }
}
