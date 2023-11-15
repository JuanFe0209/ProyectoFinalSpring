package co.edu.cue.tiendaRojas.services.impl;

import co.edu.cue.tiendaRojas.domain.entities.Order;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderDto;
import co.edu.cue.tiendaRojas.mapping.mappers.OrderMapper;
import co.edu.cue.tiendaRojas.repositories.OrderRepository;
import co.edu.cue.tiendaRojas.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    public OrderServiceImpl (OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderDto> list() {
        return OrderMapper.mapFrom((List<Order>)repository.findAll());
    }

    @Override
    public OrderDto getOrderById(int id) {
        return OrderMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public OrderDto save(OrderDto order) {
        return OrderMapper.mapFrom(
                repository.save(OrderMapper.mapFrom(order))
        );
    }

    @Override
    public OrderDto update(OrderDto order) {
        return OrderMapper.mapFrom(
                repository.save(OrderMapper.mapFrom(order))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
