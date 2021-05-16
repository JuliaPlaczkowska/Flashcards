package pwr.ib.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import pwr.ib.service.User;
import pwr.ib.service.UserDto;
import pwr.ib.service.UserDtoBuilder;

@Component
public class DbMockData {


    private UserRepo userRepository;

    @Autowired
    public DbMockData(UserRepo userRepo){
        this.userRepository = userRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill(){
        UserDto user = new UserDtoBuilder(new User("ania", "123", "ROLE_CUSTOMER")).getUserDto();
        UserDto admin = new UserDtoBuilder(new User("admin", "123", "ROLE_ADMIN")).getUserDto();

        userRepository.save(user);
        userRepository.save(admin);
    }

}
