package pl.emilkulka.expensesapp.service;

import pl.emilkulka.expensesapp.validator.user.EmailValidator;

public class UserService {

    private final EmailValidator emailValidator;

    public UserService(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }
}
