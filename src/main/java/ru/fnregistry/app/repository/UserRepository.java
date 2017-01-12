package ru.fnregistry.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.fnregistry.app.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);


    @Query(value = "SELECT users.*, requeststatus.description FROM users INNER JOIN requeststatus ON users.status=requeststatus.id", nativeQuery = true)
    List<User> findAllUsersAndRequests();
}
