package co.edu.cue.tiendaRojas.services;

import co.edu.cue.tiendaRojas.mapping.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> list();
    CustomerDto getCustomerById(int id);
    CustomerDto save(CustomerDto customer);
    CustomerDto update(CustomerDto customer);
    void delete(int id);
}
