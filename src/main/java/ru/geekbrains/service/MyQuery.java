package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

@Component
public class MyQuery {

    @Autowired
    private ProductRepository productRepository;

    public void addNewProduct(String title, int cost) {
        Product product = new Product();
        product.setTitle(title);
        product.setCost(cost);
        productRepository.save(product);
    }

}
