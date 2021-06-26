package pwr.ib.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pwr.ib.jwt.models.User;
import pwr.ib.jwt.repository.UserRepository;
import pwr.ib.jwt.security.services.UserDetailsServiceImpl;

import java.util.Optional;

@Service
public class UserManager implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UserManager(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public User save(User user){
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

            UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

        return userDetailsService.loadUserByUsername(s);
    }

    public User loadUserByUsername2(String s) throws UsernameNotFoundException {

        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

        return userDetailsService.loadUserByUsername2(userRepo, s);
    }

    public Long getCount() throws UsernameNotFoundException {
        Iterable<User> users = userRepo.findAll();

        int i=0;
        for(User u:users)
            i++;

        return Long.valueOf(i);
    }
}
