package ru.geekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Basket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket implements Serializable {
    @Id
    private String id;
    private String title;
    private int cost;
    private String name;
}

