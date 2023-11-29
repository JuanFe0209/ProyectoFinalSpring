package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.OrderProduct;
import co.edu.cue.tiendaRojas.mapping.dtos.OrderProductDto;
import co.edu.cue.tiendaRojas.services.OrderProductService;
import co.edu.cue.tiendaRojas.services.OrderService;
import co.edu.cue.tiendaRojas.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order-products")
@AllArgsConstructor
public class OrderProductController {

    private final OrderProductService orderProductService;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/list")
    public String listOrderProducts(Model model) {
        model.addAttribute("orderProducts", orderProductService.list());
        return "orderProduct/index";
    }

    @GetMapping("/create-form")
    public String createOrderProductForm(Model model) {
        model.addAttribute("orderProduct", new OrderProduct());
        model.addAttribute("products", productService.list());
        model.addAttribute("orders", orderService.list());
        return "orderProduct/create";
    }

    @PostMapping("/create")
    public String createOrderProduct(OrderProductDto orderProduct) {
        orderProductService.save(orderProduct);
        return "redirect:/order-products/list";
    }

    @GetMapping("/update-form/{id}")
    public String updateOrderProductForm(Model model, @PathVariable int id) {
        model.addAttribute("orderProduct", orderProductService.getOrder_ProductById(id));
        model.addAttribute("products", productService.list());
        model.addAttribute("orders", orderService.list());
        return "orderProduct/update";
    }

    @PostMapping("/update")
    public String updateOrderProduct(OrderProductDto orderProduct) {
        orderProductService.update(orderProduct);
        return "redirect:/order-products/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderProduct(@PathVariable int id) {
        orderProductService.delete(id);
        return "redirect:/order-products/list";
    }
}

