package pl.emilkulka.expensesapp.ExpenseTest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.emilkulka.expensesapp.exception.expense.DescriptionLimitException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.model.ExpenseType;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.service.ExpenseService;
import pl.emilkulka.expensesapp.validator.expense.DateValidator;
import pl.emilkulka.expensesapp.validator.expense.DescriptionValidator;
import pl.emilkulka.expensesapp.validator.expense.ExpenseTypeValidator;
import pl.emilkulka.expensesapp.validator.expense.PriceValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class validExpenseDescriptionTest {

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
    void setDescription_ShouldWorkCorrectly() {
        Expense expense = new Expense();

        expense.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vivamus pulvinar gravida lorem sed posuere.");

        assertEquals(100,expense.getDescription().length());
    }

    @Test
    void saveExpense_WithInvalidDescription_ShouldThrowDescriptionLimitException() {
        Expense invalidDescriptionExpense = new Expense(ExpenseType.GROCERIESANDCHEMICALS, "Valid type".repeat(100), BigDecimal.valueOf(10), LocalDate.now());

        when(descriptionValidator.isValid(invalidDescriptionExpense.getDescription())).thenReturn(true);

        assertThrows(DescriptionLimitException.class, () -> expenseService.saveExpense(invalidDescriptionExpense));
    }

    }



