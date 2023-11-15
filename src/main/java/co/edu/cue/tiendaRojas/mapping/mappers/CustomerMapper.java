package co.edu.cue.tiendaRojas.mapping.mappers;


import co.edu.cue.tiendaRojas.domain.entities.Customer;
import co.edu.cue.tiendaRojas.mapping.dtos.CustomerDto;

import java.util.List;

public class CustomerMapper {
    public static CustomerDto mapFrom(Customer source){
        return new CustomerDto(source.getCustomerId(),
                source.getName(),
                source.getLastName(),
                source.getEmail(),
                source.getAddress());
    }
    public static Customer mapFrom(CustomerDto source){
        return new Customer(source.customerId(),
                source.name(),
                source.lastName(),
                source.email(),
                source.address());
    }
    public static List<CustomerDto>mapFrom(List<Customer> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
