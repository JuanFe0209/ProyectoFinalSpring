package co.edu.cue.tiendaRojas.repositories;

import co.edu.cue.tiendaRojas.domain.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
