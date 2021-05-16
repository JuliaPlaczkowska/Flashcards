package pwr.ib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.ib.service.UserDto;


@Repository
public interface UserRepo extends CrudRepository<UserDto, Long> {

}
