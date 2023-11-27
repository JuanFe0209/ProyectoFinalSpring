package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.Order;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderDto;
import co.edu.cue.tiendaRojas.services.CustomerService;
import co.edu.cue.tiendaRojas.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @GetMapping("/list")
    public String listOrders(Model model){
        model.addAttribute("orderList", orderService.list());
        return "order/index";
    }

    @GetMapping("/create-form")
    public String createOrderForm(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("customerList", customerService.list());
        return "order/create";
    }

    @PostMapping("/create")
    public String createOrder(OrderDto order){
        orderService.save(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/edit-form/{id}")
    public String updateOrderForm(Model model, @PathVariable int id){
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("customerList", customerService.list());
        return "order/update";
    }

    @PostMapping("/update")
    public String updateOrder(OrderDto order){
        orderService.update(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id){
        orderService.delete(id);
        return "redirect:/orders/list";
    }
}
