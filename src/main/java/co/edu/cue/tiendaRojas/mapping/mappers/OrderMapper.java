package co.edu.cue.tiendaRojas.mapping.mappers;


import co.edu.cue.tiendaRojas.domain.entities.Order;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderDto;

import java.util.List;

public class OrderMapper {
    public static OrderDto mapFrom(Order source){
        return new OrderDto(source.getOrderId(),
                source.getOrderDate(),
                source.getCustomer(),
                source.getEmpresa());
    }
    public static Order mapFrom(OrderDto source){
        return new Order(source.orderId(),
                source.orderDate(),
                source.customer(),
                source.empresa());
    }

    public static List<OrderDto> mapFrom(List<Order> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}

