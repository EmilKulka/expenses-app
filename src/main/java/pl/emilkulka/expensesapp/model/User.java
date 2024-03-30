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


    @Setter
    @Getter
    private String email;

}

