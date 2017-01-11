package ru.fnregistry.app.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UserCreateForm {

    @NotEmpty
    private String email = "";

    private String surname;

    @NotEmpty
    private String firstname = "";

    private String patronymic;

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    private String birthdate;

    @NotNull
    private Role role = Role.USER;

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPasswordRepeated() {
//        return passwordRepeated;
//    }
//
//    public void setPasswordRepeated(String passwordRepeated) {
//        this.passwordRepeated = passwordRepeated;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "email='" + email.replaceFirst("@.+", "@***") + '\'' +
                surname + " " +
                firstname + " " +
                patronymic + " " +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                '}';
    }

}
