package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import pl.emilkulka.expensesapp.exception.expense.DateFromFutureException;
import pl.emilkulka.expensesapp.exception.expense.DescriptionLimitException;
import pl.emilkulka.expensesapp.exception.expense.InvalidTypeException;
import pl.emilkulka.expensesapp.exception.expense.NegativePriceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.emilkulka.expensesapp.validator.expense.DateValidator;
import pl.emilkulka.expensesapp.validator.expense.DescriptionValidator;
import pl.emilkulka.expensesapp.validator.expense.ExpenseTypeValidator;
import pl.emilkulka.expensesapp.validator.expense.PriceValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ExpenseType type;
    @Size(min=1, max=100, message = "Niepoprawny opis!")
    private String description;
    @Min(value=0, message = "Koszt nie może być ujemny!")
    private BigDecimal price;
    @PastOrPresent(message = "Data powinna być teraźniejsza lub przeszła!")
    private LocalDate date;

    public Expense(ExpenseType type, String description, BigDecimal price, LocalDate date) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.date = date;
    }
}



