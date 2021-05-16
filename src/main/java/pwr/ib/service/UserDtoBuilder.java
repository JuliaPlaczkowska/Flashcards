package pwr.ib.service;

import org.springframework.security.crypto.password.PasswordEncoder;


public class UserDtoBuilder {

    UserDto userDto;

    public UserDtoBuilder(User user) {
        this.userDto = new UserDto();
        this.userDto.setName(user.getName());
        PasswordEncoder passwordEncoder = new PasswordEncodingConfig().passwordEncoder();
        this.userDto.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        this.userDto.setRole(user.getRole());
    }

    public UserDto getUserDto() {
        return userDto;
    }

}
