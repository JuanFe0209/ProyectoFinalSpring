package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/create-product")
    public ModelAndView createProduct(){
        ModelAndView modelAndView = new ModelAndView("ProductForm");

        return modelAndView;
    }
}
