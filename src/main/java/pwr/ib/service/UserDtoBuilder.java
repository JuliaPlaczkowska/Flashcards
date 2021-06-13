package pwr.ib.service;

import org.springframework.security.crypto.password.PasswordEncoder;


public class UserDtoBuilder {

    UserDto userDto;

    public UserDtoBuilder(User user) {
        this.userDto = new UserDto();
        this.userDto.setName(user.getName());
        PasswordEncoder passwordEncoder = new PasswordEncodingConfig().passwordEncoder();
        this.userDto.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        if(user.getRole() != null)
            this.userDto.setRole(user.getRole());
        else
            this.userDto.setRole("ROLE_CUSTOMER");
    }

    public UserDto getUserDto() {
        return userDto;
    }

}
