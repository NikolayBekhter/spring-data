package ru.geekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Basket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket implements Serializable {
    private String id;
    private String title;
    private int cost;
    private String name;

//    public Basket(String id, String title, int cost, String name) {
//        this.id = id;
//        this.title = title;
//        this.cost = cost;
//        this.name = name;
//    }
}

