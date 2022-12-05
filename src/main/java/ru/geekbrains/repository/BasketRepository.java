package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, String> {
}
