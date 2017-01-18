package ru.fnregistry.app.service.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.fnregistry.app.domain.CurrentUser;
import ru.fnregistry.app.domain.User;
import ru.fnregistry.app.domain.UserCreateForm;
import ru.fnregistry.app.repository.UserRepository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        LOGGER.info("Getting user={}", id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        LOGGER.info("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.info("Getting all users");
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setSurname(form.getSurname());
        user.setFirstname(form.getFirstname());
        user.setPatronymic(form.getPatronymic());
        user.setBirthdate(form.getBirthdate().toString());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setStatus(60);
        user.setTin("0");
        user.setRequestId(BigInteger.valueOf(60L));
        user.setRequestCode(0);
        user.setRole(form.getRole());
        LOGGER.info("User " + form.getEmail() + " added");
        return userRepository.save(user);
    }

    public static String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if (!username.equals("anonymousUser")) username = username.substring(0, username.indexOf("@"));
        return username;
    }

    public static String getFirstnameAndPatronymic(){
        return "Иван Иваныч";
    }

    public static Long getUserId() {
        Long currentUserId = 0L;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if (!username.equals("anonymousUser")) {
            CurrentUser currentUser = (CurrentUser) auth.getPrincipal();
            currentUserId = currentUser.getId();
        }
        return currentUserId;
    }
}
