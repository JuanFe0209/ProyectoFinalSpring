package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.Product;
import co.edu.cue.tiendaRojas.mapping.dtos.ProductDto;
import co.edu.cue.tiendaRojas.mapping.mappers.ProductMapper;
import co.edu.cue.tiendaRojas.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/list")
    public String createProduct(Model model){
        model.addAttribute("productList", service.list());
        return "product/index";
    }

    @GetMapping("/create-form")
    public String createProductForm(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(ProductDto product){
        service.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit-form/{id}")
    public String updateProductForm(Model model, @PathVariable Long id){
        model.addAttribute("product", service.getProductById(id));
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(ProductDto product){
        service.update(product);
        return "redirect:/products/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        service.delete(id);
        return "redirect:/products/list";
    }
}
