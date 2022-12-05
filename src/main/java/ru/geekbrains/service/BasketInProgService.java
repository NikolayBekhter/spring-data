package ru.geekbrains.service;

import org.springframework.stereotype.Component;
import ru.geekbrains.model.BasketInProg;

import java.util.List;

@Component
public class BasketInProgService {

    private List<BasketInProg> basketInProgList;
    private BasketInProg basketInProg;

    public BasketInProgService(List<BasketInProg> basketInProgList) {
        this.basketInProgList = basketInProgList;
    }

    public void addToBasket(BasketInProg basketInProg) {
        basketInProgList.add(basketInProg);
    }

    public List<BasketInProg> getBasketList() {

        return basketInProgList;
    }

    public void deleteById(int id) {
        basketInProgList.remove(id);
    }
}
