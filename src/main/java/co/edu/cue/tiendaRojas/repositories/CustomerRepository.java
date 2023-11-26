package co.edu.cue.tiendaRojas.repositories;

import co.edu.cue.tiendaRojas.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
