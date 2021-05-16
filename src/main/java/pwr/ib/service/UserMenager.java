package pwr.ib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pwr.ib.repository.UserRepo;

import java.util.Optional;

@Service
public class UserMenager implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public UserMenager(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public Optional<UserDto> findById(Long id){
        return userRepo.findById(id);
    }

    public Iterable<UserDto> findAll(){
        return userRepo.findAll();
    }

    public UserDto save(UserDto user){
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Iterable<UserDto> users = userRepo.findAll();

        UserDto user = null;

        for(UserDto u:users)
            if(u.getName().equals(s))
                user =  u;

        return  new UserDetailsConfig(user);
    }
}
