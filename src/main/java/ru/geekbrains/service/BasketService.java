package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.model.Basket;
import ru.geekbrains.repository.BasketRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;

    public Basket addBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public Basket findBasketById(String id) {
        return basketRepository.findById(id)
                .filter(it -> Objects.equals(id, it.getId()))
                .orElse(null);

    }

    public List<Basket> findAll() {
        return StreamSupport.stream(basketRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Long getUserId() {
        return (long) ((Math.random() * 6) + 1);
    }

    public void deleteBasketById(String id) {
        basketRepository.deleteById(id);
    }
}
