package pl.emilkulka.expensesapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import static pl.emilkulka.expensesapp.enums.ExpenseTypes.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public DbInit(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        expenseRepository.saveAll(List.of(new Expense(1L,GROCERIESANDCHEMICALS,"Zakupy biedronka.", BigDecimal.valueOf(55.10), LocalDate.now()),
                new Expense(2L,SHOESANDCLOTHES,"Zakupy Zara.", BigDecimal.valueOf(199.99),LocalDate.now())));
    }
}
