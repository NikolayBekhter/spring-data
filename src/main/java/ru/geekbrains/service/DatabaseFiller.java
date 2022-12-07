package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.geekbrains.model.Product;
import ru.geekbrains.model.User;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DatabaseFiller {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabaseOnStartApplication() {
        productRepository.save(createProduct("Apricot", 183));
        productRepository.save(createProduct("Apple", 107));
        productRepository.save(createProduct("Lemon", 300));
        productRepository.save(createProduct("Orange", 89));
        productRepository.save(createProduct("Garnet", 344));
        productRepository.save(createProduct("Pear", 148));
        productRepository.save(createProduct("Avocado", 350));
        productRepository.save(createProduct("Pineapple", 170));
        productRepository.save(createProduct("Kiwi", 235));

        userRepository.save(createUser("Alex", 23));
        userRepository.save(createUser("Vlad", 35));
        userRepository.save(createUser("Anna", 36));
        userRepository.save(createUser("Egor", 49));
        userRepository.save(createUser("Misha", 28));
        userRepository.save(createUser("Lena", 42));

    }

    public Product createProduct(String title, int cost) {
        Product product = new Product();
        product.setTitle(title);
        product.setCost(cost);
        return product;
    }

    public User createUser(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(name + "@mail.ru");
        return user;
    }

}
