package pwr.ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;
import pwr.ib.jwt.models.User;
import pwr.ib.service.manager.UserManager;

import java.util.Optional;


@RestController
@RequestMapping
@CrossOrigin
public class UserApi {

    private UserManager users;

    @Autowired
    public UserApi(UserManager users) {this.users = users;}

    @GetMapping("api/user/hello")
    public User getCurrentUserDto(@CurrentSecurityContext(expression="authentication?.name") String username) {
        return users.loadUserByUsername2(username);
    }

    @GetMapping("api/user/all")
    public Iterable<User> getAllUsers() {
        return users.findAll();
    }

    @GetMapping("api/user")
    public Optional<User> getUserById(@RequestParam Long index) {
        return users.findById(index);
    }

    @GetMapping("api/user/byname")
    public User getUserByName(@RequestParam String username) {
        return users.loadUserByUsername2(username);
    }

    @GetMapping("api/user/count")
    public Long getUserCount() {
        return users.getCount();
    }

//implemented in  SignupRequest
//
//    @PostMapping("api/user")
//    public User addUser(@RequestBody User user ){
//        User userDto = new UserDtoBuilder(user).getUserDto();
//        return  users.save(userDto);
//    }

}
