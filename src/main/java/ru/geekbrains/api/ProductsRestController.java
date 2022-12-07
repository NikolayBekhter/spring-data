package ru.geekbrains.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.BasketDto;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.model.Product;
import ru.geekbrains.service.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsRestController {

    private final ProductService productService;
    private final MappingUtils mappingUtils;
    private final BasketService basketService;
    private final UserService userService;

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return mappingUtils.mapToProductDto(
                productService.findProductById(id)
        );
    }

    @GetMapping
    public Page<ProductDto> getProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_cost", required = false) Integer minCost,
            @RequestParam(name = "max_cost", required = false) Integer maxCost,
            @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(minCost, maxCost, titlePart, page).map(
                mappingUtils::mapToProductDto
        );
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(null);
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        return mappingUtils.mapToProductDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteByIdProduct(id);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productService.findProductById(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        return mappingUtils.mapToProductDto(productService.save(product));
    }

    @GetMapping("/baskets")
    public List<BasketDto> getProductsFromBasket() {
        return basketService.findAll()
                .stream()
                .map(mappingUtils::mapToBasketDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/baskets/{id}")
    public void setProductToBasket(@PathVariable Long id) {
        BasketDto basketDto = new BasketDto();
        basketDto.setTitle(productService.findProductById(id).getTitle());
        basketDto.setCost(productService.findProductById(id).getCost());
        basketDto.setName(userService.findUserById(basketService.getUserId()).getName());
        basketService.addBasket(mappingUtils.mapToBasket(basketDto));
    }

    @DeleteMapping("/baskets/{id}")
    public void deleteBasketDto(@PathVariable String id) {
        basketService.deleteBasketById(id);
    }



}
