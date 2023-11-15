package co.edu.cue.tiendaRojas.mapping.dtos;
import co.edu.cue.tiendaRojas.domain.entities.Customer;

import java.time.LocalDateTime;

public record OrderDto (int orderId,
                        LocalDateTime orderDate,
                        Customer customer,
                        String empresa){
}
