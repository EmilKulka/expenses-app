package pl.emilkulka.expensesapp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.emilkulka.expensesapp.dto.AppUserDto;
import pl.emilkulka.expensesapp.model.AppUser;
import pl.emilkulka.expensesapp.model.AppUserRole;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.repository.UserRepository;

import static pl.emilkulka.expensesapp.model.ExpenseType.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@AllArgsConstructor
public class DbInit implements CommandLineRunner {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        AppUser user = userRepository.findByEmail("emil53@onet.pl");
        if (user == null) {
            userRepository.save(new AppUser("Emil Kulka", passwordEncoder.encode("1234"), "emil53@onet.pl", AppUserRole.USER));
            user = userRepository.findByEmail("emil53@onet.pl");
        }

        expenseRepository.saveAll(List.of(
                new Expense(GROCERIESANDCHEMICALS, "Zakupy biedronka.", BigDecimal.valueOf(55.10), LocalDate.now(), user),
                new Expense(SHOESANDCLOTHES, "Zakupy Zara.", BigDecimal.valueOf(199.99), LocalDate.now(), user)
        ));
    }
}