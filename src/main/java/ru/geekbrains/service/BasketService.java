package ru.geekbrains.service;

import org.springframework.stereotype.Component;
import ru.geekbrains.model.Basket;
import ru.geekbrains.repository.BasketRepository;

@Component
public class BasketService {
    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void addBasket(String id, String title, int cost, String name) {
        Basket basket = new Basket(id, title, cost, name);
        basketRepository.save(basket);
    }
}
