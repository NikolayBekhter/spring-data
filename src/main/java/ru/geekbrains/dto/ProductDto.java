package ru.geekbrains.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.model.Product;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String title;

    private int cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
