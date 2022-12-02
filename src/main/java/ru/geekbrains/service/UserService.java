package ru.geekbrains.service;

import org.springframework.stereotype.Component;
import ru.geekbrains.dto.UserDto;
import ru.geekbrains.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    private UserRepository userRepository;
    private MappingUtils mappingUtils;
    public UserService(UserRepository userRepository, MappingUtils mappingUtils) {
        this.userRepository = userRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(mappingUtils::mapToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto findUserById(Long id) {
        return mappingUtils.mapToUserDto(
                userRepository.getById(id)
        );
    }

    public void saveUser(UserDto userDto) {
        userRepository.save(mappingUtils.mapToUser(userDto));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
