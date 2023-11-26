package co.edu.cue.tiendaRojas.mapping.mappers;


import co.edu.cue.tiendaRojas.domain.entities.OrderProduct;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderProductDto;

import java.util.List;

public class OrderProductMapper {
    public static OrderProductDto mapFrom(OrderProduct source){
        return new OrderProductDto(source.getId(),
                source.getOrder(),
                source.getProduct(),
                source.getQuantity(),
                source.getUnitPrice(),
                source.getTotalPrice());
    }
    public static OrderProduct mapFrom(OrderProductDto source){
        return new OrderProduct(source.id(),
                source.order(),
                source.product(),
                source.quantity(),
                source.unitPrice(),
                source.totalPrice());
    }
    public static List<OrderProductDto> mapFrom(List<OrderProduct> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
