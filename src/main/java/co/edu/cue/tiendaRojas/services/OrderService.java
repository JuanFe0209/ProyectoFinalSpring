package co.edu.cue.tiendaRojas.services;


import co.edu.cue.tiendaRojas.mapping.dtos.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> list();
    OrderDto getOrderById(int id);
    OrderDto save(OrderDto order);
    OrderDto update(OrderDto order);
    void delete(int id);
}
