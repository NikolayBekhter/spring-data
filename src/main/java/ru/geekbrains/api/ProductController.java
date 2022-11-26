package ru.geekbrains.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.MyQuery;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MyQuery myQuery;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.getById(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public void addProduct(@RequestParam String title, @RequestParam int cost) {
        myQuery.addNewProduct(title, cost);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

}
