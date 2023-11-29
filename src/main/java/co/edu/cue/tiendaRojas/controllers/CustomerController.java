package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.Customer;
import co.edu.cue.tiendaRojas.mapping.dtos.CustomerDto;
import co.edu.cue.tiendaRojas.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customerList", customerService.list());
        return "customer/index";
    }

    @GetMapping("/create-form")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(CustomerDto customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/edit-form/{id}")
    public String updateCustomerForm(Model model, @PathVariable int id) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/update";
    }

    @PostMapping("/update")
    public String updateCustomer(CustomerDto customer) {
        customerService.update(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
        return "redirect:/customers/list";
    }
}
