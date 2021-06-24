package pwr.ib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.ib.jwt.models.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
