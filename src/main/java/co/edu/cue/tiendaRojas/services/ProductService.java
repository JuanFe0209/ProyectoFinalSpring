package co.edu.cue.tiendaRojas.services;

import co.edu.cue.tiendaRojas.mapping.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> list();
    ProductDto getProductById(Long id);
    ProductDto save(ProductDto product);
    ProductDto update(ProductDto product);
    void delete(Long id);
}
