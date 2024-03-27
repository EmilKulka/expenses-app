package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
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
    private String description;
    private BigDecimal price;
    private LocalDate date;

    @Transient
    private final ExpenseTypeValidator expenseTypeValidator = new ExpenseTypeValidator();
    @Transient
    private final DescriptionValidator descriptionValidator = new DescriptionValidator();
    @Transient
    private final PriceValidator priceValidator = new PriceValidator();
    @Transient
    private final DateValidator dateValidator = new DateValidator();

    public Expense(ExpenseType type, String description, BigDecimal price, LocalDate date) {

        if (expenseTypeValidator.isValid(type)) {
            throw new InvalidTypeException();
        }
        this.type = type;

        if (descriptionValidator.isValid(description)) {
            throw new DescriptionLimitException();
        }
        this.description = description;

        if (priceValidator.isValid(price)) {
            throw new NegativePriceException();
        }
        this.price = price;

        if (dateValidator.isValid(date)) {
            throw new DateFromFutureException();
        }
        this.date = date;
    }

    public void setType(ExpenseType type) {
        if (expenseTypeValidator.isValid(type)) {
            throw new InvalidTypeException();
        }
        this.type = type;
    }

    public void setDescription(String description) {
        if (descriptionValidator.isValid(description)) {
            throw new DescriptionLimitException();
        }
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        if (priceValidator.isValid(price)) {
            throw new NegativePriceException();
        }
        this.price = price;
    }

    public void setDate(LocalDate date) {
        if (dateValidator.isValid(date)) {
            throw new DateFromFutureException();
        }
        this.date = date;
    }
}



