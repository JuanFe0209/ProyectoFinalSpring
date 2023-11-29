package co.edu.cue.tiendaRojas.services.impl;

import co.edu.cue.tiendaRojas.domain.entities.Customer;
import co.edu.cue.tiendaRojas.mapping.dtos.CustomerDto;
import co.edu.cue.tiendaRojas.mapping.mappers.CustomerMapper;
import co.edu.cue.tiendaRojas.repositories.CustomerRepository;
import co.edu.cue.tiendaRojas.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerDto> list() {
        return CustomerMapper.mapFrom((List<Customer>)repository.findAll());
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        return CustomerMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        return CustomerMapper.mapFrom(
                repository.save(CustomerMapper.mapFrom(customer))
        );
    }

    @Override
    public CustomerDto update(CustomerDto customer) {
        return CustomerMapper.mapFrom(
                repository.save(CustomerMapper.mapFrom(customer))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
