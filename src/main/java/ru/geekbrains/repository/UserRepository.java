package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
