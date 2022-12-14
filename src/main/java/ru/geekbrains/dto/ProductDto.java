package ru.geekbrains.dto;

import lombok.*;
import ru.geekbrains.model.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String title;

    private int cost;
}
