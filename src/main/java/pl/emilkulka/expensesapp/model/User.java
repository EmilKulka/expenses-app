package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.emilkulka.expensesapp.exception.user.EmailFormatException;
import pl.emilkulka.expensesapp.validator.user.EmailValidator;

@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @Transient
    private final EmailValidator emailValidator = new EmailValidator();

    @Getter
    private String email;

    public void setEmail(String email) {
        if (!emailValidator.isValid(email)) {
            throw new EmailFormatException();
        }
        this.email = email;
    }
}

