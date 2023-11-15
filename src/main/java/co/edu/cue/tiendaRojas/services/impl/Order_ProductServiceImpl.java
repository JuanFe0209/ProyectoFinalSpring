package co.edu.cue.tiendaRojas.services.impl;

import co.edu.cue.tiendaRojas.domain.entities.Order_Product;
import co.edu.cue.tiendaRojas.mapping.dtos.Order_ProductDto;
import co.edu.cue.tiendaRojas.mapping.mappers.Order_ProductMapper;
import co.edu.cue.tiendaRojas.repositories.Order_ProductRepository;
import co.edu.cue.tiendaRojas.services.Order_ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Order_ProductServiceImpl implements Order_ProductService {
    private final Order_ProductRepository repository;

    public Order_ProductServiceImpl(Order_ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Order_ProductDto> list() {
        return Order_ProductMapper.mapFrom((List<Order_Product>)repository.findAll());
    }

    @Override
    public Order_ProductDto getOrder_ProductById(int id) {
        return Order_ProductMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public Order_ProductDto save(Order_ProductDto order_product) {
        return Order_ProductMapper.mapFrom(
                repository.save(Order_ProductMapper.mapFrom(order_product))
        );
    }

    @Override
    public Order_ProductDto update(Order_ProductDto order_product) {
        return Order_ProductMapper.mapFrom(
                repository.save(Order_ProductMapper.mapFrom(order_product))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
