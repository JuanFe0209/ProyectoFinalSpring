package co.edu.cue.tiendaRojas.mapping.mappers;



import co.edu.cue.tiendaRojas.domain.entities.Product;
import co.edu.cue.tiendaRojas.mapping.dtos.ProductDto;

import java.util.List;

public class ProductMapper {
    public static ProductDto mapFrom(Product source){
        return new ProductDto(source.getProductId(),
                source.getName(),
                source.getPrice(),
                source.getStock());
    }
    public static Product mapFrom(ProductDto source){
        return new Product(source.productId(),
                source.name(),
                source.price(),
                source.stock());
    }
    public static List<ProductDto> mapFrom(List<Product> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}

