package co.edu.cue.tiendaRojas.services.impl;

import co.edu.cue.tiendaRojas.domain.entities.OrderProduct;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderProductDto;
import co.edu.cue.tiendaRojas.mapping.mappers.OrderProductMapper;
import co.edu.cue.tiendaRojas.repositories.OrderProductRepository;
import co.edu.cue.tiendaRojas.services.OrderProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository repository;

    public OrderProductServiceImpl(OrderProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderProductDto> list() {
        return OrderProductMapper.mapFrom((List<OrderProduct>)repository.findAll());
    }

    @Override
    public OrderProductDto getOrder_ProductById(int id) {
        return OrderProductMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public OrderProductDto save(OrderProductDto order_product) {
        return OrderProductMapper.mapFrom(
                repository.save(OrderProductMapper.mapFrom(order_product))
        );
    }

    @Override
    public OrderProductDto update(OrderProductDto order_product) {
        return OrderProductMapper.mapFrom(
                repository.save(OrderProductMapper.mapFrom(order_product))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
