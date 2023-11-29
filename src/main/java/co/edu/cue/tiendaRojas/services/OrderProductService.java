package co.edu.cue.tiendaRojas.services;


import co.edu.cue.tiendaRojas.mapping.dtos.OrderProductDto;

import java.util.List;

public interface OrderProductService {
    List<OrderProductDto> list();
    OrderProductDto getOrder_ProductById(int id);
    OrderProductDto save(OrderProductDto order_product);
    OrderProductDto update(OrderProductDto order_product);
    void delete(int id);
}
