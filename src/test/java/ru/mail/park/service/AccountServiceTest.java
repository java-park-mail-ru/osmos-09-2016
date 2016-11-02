//package ru.mail.park.service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.mail.park.DAO2.UserRequestsDAO;
//import ru.mail.park.model.UserForResponse;
//import ru.mail.park.model.UserProfile;
//import ru.mail.park.servicies.AccountService;
//
//
//import java.util.List;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertSame;
//
//
//public class AccountServiceTest {
//
//    private AccountService accountService;
//
//    private UserRequestsDAO userDao;
//
//    @Before
//    public void setup(){
//        userDao = new UserRequestsDAO() {
//            @Override
//            public Long addNewUser(String login, String name, String email, String password) {
//                return null;
//            }
//
//            @Override
//            public List<UserForResponse> getAllUsers() {
//                return null;
//            }
//
//            @Override
//            public UserProfile existingUserByLogin(String login) {
//                return null;
//            }
//
//            @Override
//            public UserProfile getUserById(Long id) {
//                return null;
//            }
//
//            @Override
//            public Boolean removeUser(Long id) {
//                return null;
//            }
//        };
//    }
//
//    @Test
//    public void testExistingUserByLogin(){
//        UserProfile user = accountService.existingUserByLogin("Sergey");
//        assertNotNull(user);
//
//        assertSame(user, accountService.existingUserByLogin("Sergey"));
//    }
//
//
//}
