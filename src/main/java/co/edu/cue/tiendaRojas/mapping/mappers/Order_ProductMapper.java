package co.edu.cue.tiendaRojas.mapping.mappers;


import co.edu.cue.tiendaRojas.domain.entities.Order_Product;
import co.edu.cue.tiendaRojas.mapping.dtos.Order_ProductDto;

import java.util.List;

public class Order_ProductMapper {
    public static Order_ProductDto mapFrom(Order_Product source){
        return new Order_ProductDto(source.getOrder(),
                source.getProduct(),
                source.getQuantity(),
                source.getUnitPrice(),
                source.getTotalPrice());
    }
    public static Order_Product mapFrom(Order_ProductDto source){
        return new Order_Product(source.order(),
                source.product(),
                source.quantity(),
                source.unitPrice(),
                source.totalPrice());
    }
    public static List<Order_ProductDto> mapFrom(List<Order_Product> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
