package pwr.ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.User;
import pwr.ib.service.UserDto;
import pwr.ib.service.UserMenager;

import java.util.Optional;

@RestController
@RequestMapping
public class UserApi {

    private UserMenager users;

    @Autowired
    public UserApi(UserMenager users) {this.users = users;}

    @GetMapping("api/user/all")
    public Iterable<UserDto> getAllUsers() {
        return users.findAll();
    }

    @GetMapping("api/User")
    public Optional<UserDto> getUserById(@RequestParam Long index) {
        return users.findById(index);
    }

    @PostMapping("api/admin/User")
    public UserDto addUser(@RequestBody UserDto user ){
        return  users.save(user);
    }

    @PutMapping("api/admin/User")
    public UserDto updateUser(@RequestBody UserDto user ){
        return  users.save(user);
    }

    @PatchMapping("api/admin/User")
    public UserDto partlyUpdateUser(@RequestBody UserDto user ){
        return  users.save(user);
    }

}
