package ru.mail.park.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.park.ResponseInJson.IdResponse;
import ru.mail.park.ResponseInJson.RegistrationRequest;
import ru.mail.park.ResponseInJson.SuccessResponse;
import ru.mail.park.model.UserProfile;
import ru.mail.park.servicies.AccountService;

@RestController
public class RegistrationController {

  @Autowired
  private HttpSession httpSession;

  @Autowired
  private AccountService accountService;

  @RequestMapping(value = "/api/users", method = RequestMethod.GET)
  public List<UserProfile> getAllUsers() {
    // TODO пароли отдаём наружу? совсем ужас - надо переделать и не отдавать
    return accountService.getAllUsers();
  }

  @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {

    final UserProfile user = accountService.getUserById(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"User not exist\"}");
    }
    return ResponseEntity.ok(new SuccessResponse(user.getLogin()));
  }

  @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeUserById(@PathVariable("id") Integer id) {
    Integer loggedInUserId = (Integer) httpSession.getAttribute("userId");
    if (!loggedInUserId.equals(id)) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cannot remove other user");
    }
    accountService.removeUserById(id);
    return ResponseEntity.ok("User removed");
  }

  @RequestMapping(value = "/api/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> login(@RequestBody RegistrationRequest body) {

    final String login = body.getLogin();
    final String password = body.getPassword();
    final String email = body.getEmail();
    final String name = body.getName();

    if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password) || StringUtils.isEmpty(email)) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{\"error\":\"empty data\"}");
    }
    final UserProfile existingUser = accountService.existingUserByLogin(login);
    if (existingUser != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          "{\"error\":\"User with this login already exist\"}");
    }

    final Integer id = accountService.addUser(login, name, password, email);

    return ResponseEntity.ok(new IdResponse(id));
  }

  @RequestMapping(value = "/api/sessions", method = RequestMethod.POST)
  public ResponseEntity auth(@RequestBody RegistrationRequest body) {
    final String login = body.getLogin();
    final String password = body.getPassword();

    if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"invalid data\"}");
    }

    UserProfile user = accountService.existingUserByLogin(login);
    // TODO check password
    httpSession.setAttribute("userId", user.getId());

    return ResponseEntity.ok("Success");
  }

}
