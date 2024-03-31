package pl.emilkulka.expensesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.emilkulka.expensesapp.exception.expense.DateFromFutureException;
import pl.emilkulka.expensesapp.exception.expense.DescriptionLimitException;
import pl.emilkulka.expensesapp.exception.expense.InvalidTypeException;
import pl.emilkulka.expensesapp.exception.expense.NegativePriceException;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.validator.expense.DateValidator;
import pl.emilkulka.expensesapp.validator.expense.DescriptionValidator;
import pl.emilkulka.expensesapp.validator.expense.ExpenseTypeValidator;
import pl.emilkulka.expensesapp.validator.expense.PriceValidator;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final DateValidator dateValidator;
    private final DescriptionValidator descriptionValidator;
    private final ExpenseTypeValidator expenseTypeValidator;
    private final PriceValidator priceValidator;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, DateValidator dateValidator,
                          DescriptionValidator descriptionValidator, ExpenseTypeValidator expenseTypeValidator,
                          PriceValidator priceValidator) {
        this.expenseRepository = expenseRepository;
        this.dateValidator = dateValidator;
        this.descriptionValidator = descriptionValidator;
        this.expenseTypeValidator = expenseTypeValidator;
        this.priceValidator = priceValidator;
    }

    public void saveExpense(Expense expense) {
        if (descriptionValidator.isValid(expense.getDescription())) {
            throw new DescriptionLimitException();
        }
        if (expenseTypeValidator.isValid(expense.getType())) {
            throw new InvalidTypeException();
        }
        if (priceValidator.isValid(expense.getPrice())) {
            throw new NegativePriceException();
        }
        if (dateValidator.isValid(expense.getDate())) {
            throw new DateFromFutureException();
        }

        expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).get();
    }

    public void updateExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}
