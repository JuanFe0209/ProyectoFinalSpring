package co.edu.cue.tiendaRojas.mapping.dtos;
import co.edu.cue.tiendaRojas.domain.entities.Order;
import co.edu.cue.tiendaRojas.domain.entities.Product;


public record OrderProductDto(int id,
                              Order order,
                              Product product,
                              int quantity,
                              int unitPrice,
                              int totalPrice) {

}
