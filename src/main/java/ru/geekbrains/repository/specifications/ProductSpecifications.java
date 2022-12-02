package ru.geekbrains.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.model.Product;

public class ProductSpecifications {
    public static Specification<Product> costGreaterOrEqualsThan(Integer minCost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), minCost);
    }

    public static Specification<Product> costLessOrEqualsThan(Integer maxCost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), maxCost);
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

}
