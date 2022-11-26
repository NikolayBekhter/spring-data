package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

@Component
public class DatabaseFiller {

    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApplication() {
        productRepository.save(createProduct("Apricot", 50));
        productRepository.save(createProduct("Apple", 10));
        productRepository.save(createProduct("Lemon", 30));
        productRepository.save(createProduct("Orange", 17));
        productRepository.save(createProduct("Garnet", 35));
        productRepository.save(createProduct("Pear", 15));

    }

    public Product createProduct(String title, int cost) {
        Product product = new Product();
        product.setTitle(title);
        product.setCost(cost);
        return product;
    }

}
