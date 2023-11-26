package co.edu.cue.tiendaRojas.services.impl;

import co.edu.cue.tiendaRojas.domain.entities.Product;
import co.edu.cue.tiendaRojas.mapping.dtos.ProductDto;
import co.edu.cue.tiendaRojas.mapping.mappers.ProductMapper;
import co.edu.cue.tiendaRojas.repositories.ProductRepository;
import co.edu.cue.tiendaRojas.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDto> list() {
        return ProductMapper.mapFrom((List<Product>)repository.findAll());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return ProductMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public ProductDto save(ProductDto product) {
        return ProductMapper.mapFrom(
                repository.save(ProductMapper.mapFrom(product))
        );
    }

    @Override
    public ProductDto update(ProductDto product) {
        return ProductMapper.mapFrom(
                repository.save(ProductMapper.mapFrom(product))
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
