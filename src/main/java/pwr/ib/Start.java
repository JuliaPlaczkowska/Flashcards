package pwr.ib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pwr.ib.repository.UserRepo;

@Component
public class Start {

    private UserRepo userRepo;

    @Autowired
    public Start(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

    }
}