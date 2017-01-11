package ru.fnregistry.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.fnregistry.app.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
//        String host = "0.0.0.0";
//        int port = 8080;
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
