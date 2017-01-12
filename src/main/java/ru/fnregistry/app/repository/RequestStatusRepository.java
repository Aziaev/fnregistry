package ru.fnregistry.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fnregistry.app.domain.User;

import java.util.Optional;

public interface RequestStatusRepository extends JpaRepository<User, Long> {
    Optional<User> findOneById(int id);
}
