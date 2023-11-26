package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.Customer;
import co.edu.cue.tiendaRojas.mapping.dtos.CustomerDto;
import co.edu.cue.tiendaRojas.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/list")
    public String listAllCustomer(Model model){
        List<CustomerDto> customerList = service.list();
        model.addAttribute("customerList", customerList);
        return "index";
    }
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "form";
    }

}

