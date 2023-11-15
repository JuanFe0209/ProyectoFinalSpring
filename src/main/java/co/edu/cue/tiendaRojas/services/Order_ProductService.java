package co.edu.cue.tiendaRojas.services;


import co.edu.cue.tiendaRojas.mapping.dtos.Order_ProductDto;

import java.util.List;

public interface Order_ProductService {
    List<Order_ProductDto> list();
    Order_ProductDto getOrder_ProductById(int id);
    Order_ProductDto save(Order_ProductDto order_product);
    Order_ProductDto update(Order_ProductDto order_product);
    void delete(int id);
}
