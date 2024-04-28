package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private ExpenseType type;
    @Size(min = 1, max = 100, message = "Niepoprawny opis!")
    private String description;
    @Min(value = 0, message = "Koszt nie może być ujemny!")
    private BigDecimal price;
    @PastOrPresent(message = "Data powinna być teraźniejsza lub przeszła!")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    AppUser user;

    public Expense(ExpenseType type, String description, BigDecimal price, LocalDate date, AppUser user) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.date = date;
        this.user = user;

    }
}



