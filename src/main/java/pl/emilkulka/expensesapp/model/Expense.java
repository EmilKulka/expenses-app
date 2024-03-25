package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
import pl.emilkulka.expensesapp.exception.DateFromFutureException;
import pl.emilkulka.expensesapp.exception.DescriptionLimitException;
import pl.emilkulka.expensesapp.exception.NegativePriceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private ExpenseType type;
    private String description;
    private BigDecimal price;
    private LocalDate date;
    private static Long idCount = 0L;

    public Expense(ExpenseType type, String description, BigDecimal price, LocalDate date) {
        this.id = ++idCount;
        this.type = type;
        if (isDescriptionInvalid(description)) {
            throw new DescriptionLimitException();
        }
        this.description = description;
        if (isPriceNegative(price)) {
            throw new NegativePriceException();
        }
        this.price = price;
        if(isDateFromFuture(date)) {
            throw new DateFromFutureException();
        }
        this.date = date;
        id ++;
    }

    public boolean isDescriptionInvalid(String description) {
        return description.length() > 100;
    }

    public void setDescription(String description) {
        if (isDescriptionInvalid(description)) {
            throw new DescriptionLimitException();
        }
        this.description = description;
    }

    public boolean isPriceNegative(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) < 0;
    }

    public void setPrice(BigDecimal price) {
        if (isPriceNegative(price)) {
            throw new NegativePriceException();
        }
        this.price = price;
    }

    public boolean isDateFromFuture(LocalDate date) {
        LocalDate localDate = LocalDate.now();
        return date.isAfter(localDate);
    }

    public void setDate(LocalDate date) {
        if(isDateFromFuture(date)) {
            throw new DateFromFutureException();
        }
        this.date = date;
    }
}



