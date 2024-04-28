package pl.emilkulka.expensesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilkulka.expensesapp.model.Expense;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
