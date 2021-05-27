package pwr.ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.User;
import pwr.ib.service.UserDto;
import pwr.ib.service.UserDtoBuilder;
import pwr.ib.service.UserManager;

import java.util.Optional;

@RestController
@RequestMapping
public class UserApi {

    private UserManager users;

    @Autowired
    public UserApi(UserManager users) {this.users = users;}

    @GetMapping("api/user/all")
    public Iterable<UserDto> getAllUsers() {
        return users.findAll();
    }

    @GetMapping("api/user")
    public Optional<UserDto> getUserById(@RequestParam Long index) {
        return users.findById(index);
    }

    @PostMapping("api/user")
    public UserDto addUser(@RequestBody User user ){
        UserDto userDto = new UserDtoBuilder(user).getUserDto();
        return  users.save(userDto);
    }

    @PutMapping("api/admin/user")
    public UserDto updateUser(@RequestBody UserDto user ){
        return  users.save(user);
    }

}
