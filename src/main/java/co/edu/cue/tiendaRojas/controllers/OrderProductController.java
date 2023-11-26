package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.OrderProduct;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderProductDto;
import co.edu.cue.tiendaRojas.services.OrderProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order-products")
@AllArgsConstructor
public class OrderProductController {

    private final OrderProductService orderProductService;

    @GetMapping("/list")
    public ModelAndView listOrderProducts() {
        ModelAndView modelAndView = new ModelAndView("orderproduct/list");
        modelAndView.addObject("orderProductList", orderProductService.list());
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newOrderProduct() {
        ModelAndView modelAndView = new ModelAndView("orderproduct/form");
        modelAndView.addObject("orderProduct", new OrderProduct());
        return modelAndView;
    }

    @PostMapping("/new")
    public String createOrderProduct(@ModelAttribute OrderProductDto orderProduct) {
        orderProductService.save(orderProduct);
        return "redirect:/order-products/list?success";
    }
}
