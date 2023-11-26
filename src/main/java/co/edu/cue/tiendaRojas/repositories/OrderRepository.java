package co.edu.cue.tiendaRojas.repositories;

import co.edu.cue.tiendaRojas.domain.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
