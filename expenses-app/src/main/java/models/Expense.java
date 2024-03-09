package models;

import enums.ExpenseTypes;
import exceptions.DateFromFutureException;
import exceptions.DescriptionLimitException;
import exceptions.NegativePriceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Expense {
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



