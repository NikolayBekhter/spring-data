package ru.geekbrains.repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class StudentRepository {
    private static int IDCOUNT = 0;
    private List<Product> products = new ArrayList<>();
    private Product product;

    @PostConstruct
    public void addProducts () {
        products.add(new Product(++IDCOUNT,"Apple", 10));
        products.add(new Product(++IDCOUNT,"Lemon", 30));
        products.add(new Product(++IDCOUNT,"Orange", 17));
        products.add(new Product(++IDCOUNT,"Garnet", 35));
        products.add(new Product(++IDCOUNT,"Pear", 15));
    }

    public void addProduct (String title, int cost) {
        products.add(new Product(++IDCOUNT, title, cost));
    }

    public void deleteProduct(int id) {
        for(int i = products.size() - 1; i >= 0; --i)
        {
            if(products.get(i).getId() == id)
            {
                products.remove(i);
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printProductList(){
        products.forEach((product) -> {
            System.out.println(product.toString());
        });
    }
    public Product getProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        System.out.println("Нет такого товара!");
        return null;
    }

}
