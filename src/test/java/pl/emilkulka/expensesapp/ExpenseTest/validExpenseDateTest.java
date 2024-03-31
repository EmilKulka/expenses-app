package pl.emilkulka.expensesapp.ExpenseTest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cglib.core.Local;
import pl.emilkulka.expensesapp.exception.expense.DateFromFutureException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.model.ExpenseType;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.service.ExpenseService;
import pl.emilkulka.expensesapp.validator.expense.DateValidator;
import pl.emilkulka.expensesapp.validator.expense.DescriptionValidator;
import pl.emilkulka.expensesapp.validator.expense.ExpenseTypeValidator;
import pl.emilkulka.expensesapp.validator.expense.PriceValidator;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;


public class validExpenseDateTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private DateValidator dateValidator;

    @Mock
    private DescriptionValidator descriptionValidator;

    @Mock
    private ExpenseTypeValidator expenseTypeValidator;

    @Mock
    private PriceValidator priceValidator;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void setDate_ShouldWorkCorrectly() {
        Expense expense = new Expense();

        expense.setDate(LocalDate.of(2024, 2, 2));

        assertEquals(LocalDate.of(2024,2,2), expense.getDate());
    }

    @Test
    void saveExpense_WithFutureDate_ShouldThrowDateFromFutureException() {
        Expense futureDateExpense = new Expense(ExpenseType.GROCERIESANDCHEMICALS, "Valid type", BigDecimal.valueOf(10), LocalDate.now().plusDays(1));

        when(dateValidator.isValid(futureDateExpense.getDate())).thenReturn(true);

        assertThrows(DateFromFutureException.class, () -> expenseService.saveExpense(futureDateExpense));
    }

}

