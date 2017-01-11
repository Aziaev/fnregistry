package ru.fnregistry.app.service.user;

import ru.fnregistry.app.domain.User;
import ru.fnregistry.app.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
