package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.repository.specifications.ProductSpecifications;

@Component
public class ProductService {

    private ProductRepository productRepository;
    private MappingUtils mappingUtils;

    public ProductService(ProductRepository productRepository, MappingUtils mappingUtils) {
        this.productRepository = productRepository;
        this.mappingUtils = mappingUtils;
    }

    public void save(ProductDto productDto) {
        productRepository.save(mappingUtils.mapToProduct(productDto));
    }

    public void deleteByIdProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto findUserById(Long id) {
        return mappingUtils.mapToProductDto(
                productRepository.getById(id)
        );
    }

    public Page<Product> find(Integer minCost, Integer maxCost, String titlePart, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minCost != null) {
            spec = spec.and(ProductSpecifications.costGreaterOrEqualsThan(minCost));
        }
        if (maxCost != null) {
            spec = spec.and(ProductSpecifications.costLessOrEqualsThan(maxCost));
        }
        if (titlePart != null) {
            spec = spec.and(ProductSpecifications.titleLike(titlePart));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }

}
