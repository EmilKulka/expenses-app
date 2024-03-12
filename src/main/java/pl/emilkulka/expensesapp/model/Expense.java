package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import pl.emilkulka.expensesapp.enums.ExpenseTypes;
import pl.emilkulka.expensesapp.exception.DateFromFutureException;
import pl.emilkulka.expensesapp.exception.DescriptionLimitException;
import pl.emilkulka.expensesapp.exception.NegativePriceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private ExpenseTypes type;
    private String description;
    private BigDecimal price;
    private LocalDate date;

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



