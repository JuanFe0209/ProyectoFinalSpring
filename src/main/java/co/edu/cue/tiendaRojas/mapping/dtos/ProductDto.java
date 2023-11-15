package co.edu.cue.tiendaRojas.mapping.dtos;

public record ProductDto(int productId,
                         String name,
                         int price,
                         Boolean stock) {
}
