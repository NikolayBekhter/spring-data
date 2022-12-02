package ru.geekbrains.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.geekbrains.model.User;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {

    private Long id;
    private String name;
    private int age;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.email = user.getEmail();
    }
}
