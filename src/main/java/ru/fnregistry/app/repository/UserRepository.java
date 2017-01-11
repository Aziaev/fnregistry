package ru.fnregistry.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.fnregistry.app.domain.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}
