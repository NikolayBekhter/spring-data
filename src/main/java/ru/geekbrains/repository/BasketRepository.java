package ru.geekbrains.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Basket;

@Repository
public interface BasketRepository extends KeyValueRepository<Basket, String> {
}
