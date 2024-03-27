package pl.emilkulka.expensesapp.validator.user;

import pl.emilkulka.expensesapp.validator.FieldValidator;

public class EmailValidator implements FieldValidator<String> {
    public boolean isValid(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

}
