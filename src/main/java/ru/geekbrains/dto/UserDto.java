package ru.geekbrains.dto;

import lombok.*;
import ru.geekbrains.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private int age;
    private String email;
}
