package ru.geekbrains.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.model.BasketInProg;
import ru.geekbrains.model.Product;
import ru.geekbrains.service.BasketInProgService;
import ru.geekbrains.service.BasketService;
import ru.geekbrains.service.MappingUtils;
import ru.geekbrains.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsRestController {

    private final ProductService productService;
    private MappingUtils mappingUtils;
    private BasketInProgService basketInProgService;
    private final BasketService basketService;

    @Autowired
    public ProductsRestController(ProductService productService,
                                  MappingUtils mappingUtils,
                                  BasketInProgService basketInProgService,
                                  BasketService basketService) {
        this.productService = productService;
        this.mappingUtils = mappingUtils;
        this.basketInProgService = basketInProgService;
        this.basketService = basketService;
    }

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
                p -> mappingUtils.mapToProductDto(p)
        );
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productDto.setId(null);
        Product product = mappingUtils.mapToProduct(productDto);
        return mappingUtils.mapToProductDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteByIdProduct(id);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = mappingUtils.mapToProduct(productDto);
        return mappingUtils.mapToProductDto(productService.save(product));
    }

    @GetMapping("/basket")
    public List<BasketInProg> getProductsFromBasket() {
        return basketInProgService.getBasketList();
    }

    @GetMapping("/basket/{id}")
    public void setProductToBasket(@PathVariable Long id) {
        BasketInProg basketInProg = new BasketInProg(
                productService.findProductById(id).getTitle(),
                productService.findProductById(id).getCost(),
                "Lena");
        basketInProgService.addToBasket(basketInProg);
        String idBasket = basketInProg.getClass().getSimpleName() + basketInProg.hashCode() + basketInProg.getName();
        basketService.addBasket(idBasket,
                productService.findProductById(id).getTitle(),
                productService.findProductById(id).getCost(),
                "Lena");
        System.out.println(idBasket);
    }

}
