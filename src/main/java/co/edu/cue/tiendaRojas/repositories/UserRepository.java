package co.edu.cue.tiendaRojas.repositories;

import co.edu.cue.tiendaRojas.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
