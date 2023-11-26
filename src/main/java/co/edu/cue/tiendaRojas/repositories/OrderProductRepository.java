package co.edu.cue.tiendaRojas.repositories;

import co.edu.cue.tiendaRojas.domain.entities.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {
}
