package ru.geekbrains.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.UserDto;
import ru.geekbrains.model.User;
import ru.geekbrains.service.MappingUtils;
import ru.geekbrains.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersRestController {

    private final UserService userService;
    private final MappingUtils mappingUtils;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(mappingUtils::mapToUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return mappingUtils.mapToUserDto(userService.findUserById(id));
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setId(null);
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        return mappingUtils.mapToUserDto(userService.saveUser(user));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userService.findUserById(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        return mappingUtils.mapToUserDto(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
