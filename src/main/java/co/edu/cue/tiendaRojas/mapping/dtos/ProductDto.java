package co.edu.cue.tiendaRojas.mapping.dtos;

public record ProductDto(Long productId,
                         String name,
                         int price,
                         Boolean stock) {
}
