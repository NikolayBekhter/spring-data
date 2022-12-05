package ru.geekbrains.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class BasketInProg {
    private String title;
    private int cost;
    private String name;


    public BasketInProg(String title, int cost, String name) {
        this.title = title;
        this.cost = cost;
        this.name = name;

    }
}
