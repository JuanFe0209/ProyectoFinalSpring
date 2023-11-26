package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.Order;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderDto;
import co.edu.cue.tiendaRojas.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/list")
    public ModelAndView listOrders() {
        ModelAndView modelAndView = new ModelAndView("order/list");
        modelAndView.addObject("orderList", orderService.list());
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newOrder() {
        ModelAndView modelAndView = new ModelAndView("order/form");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }

    @PostMapping("/new")
    public String createOrder(@ModelAttribute OrderDto order) {
        orderService.save(order);
        return null;
    }
}