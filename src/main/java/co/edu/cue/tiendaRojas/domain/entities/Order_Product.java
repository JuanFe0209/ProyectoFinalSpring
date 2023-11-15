package co.edu.cue.tiendaRojas.domain.entities;
import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_product")
public class Order_Product {

    private Order order;
    private Product product;
    private int quantity;
    private int unitPrice;
    private int totalPrice;
}
