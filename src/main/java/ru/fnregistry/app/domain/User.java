package ru.fnregistry.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "surname")
    private String surname;

    @Column (name = "firstname", nullable = false)
    private String firstname;

    @Column (name = "patronymic")
    private String patronymic;

    @Column (name = "birthdate")
    private String birthdate;

    @Column (name = "tin")
    private int tin;

    @Column (name = "status")
    private BigInteger status;

    @Column (name = "requestId")
    private BigInteger requestId;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
