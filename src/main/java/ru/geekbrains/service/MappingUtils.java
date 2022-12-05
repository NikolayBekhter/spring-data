package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.dto.UserDto;
import ru.geekbrains.model.Product;
import ru.geekbrains.model.User;

@Service
public class MappingUtils {

    //из user в dto
    public UserDto mapToUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getAge(), user.getEmail());

    }
    //из dto в user
    public User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getAge(), userDto.getEmail());
    }
    //из product в dto
    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
    //из dto в product
    public Product mapToProduct(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }
}
