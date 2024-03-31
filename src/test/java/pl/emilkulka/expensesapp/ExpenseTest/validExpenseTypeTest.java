package pl.emilkulka.expensesapp.ExpenseTest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.emilkulka.expensesapp.exception.expense.InvalidTypeException;
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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class validExpenseTypeTest {

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
    void setTypeShouldWorkCorrectly() {
        Expense expense = new Expense();
        ExpenseType expectedType = ExpenseType.GROCERIESANDCHEMICALS;

        expense.setType(expectedType);

        assertEquals(expectedType, expense.getType());
    }

    @Test
    void saveExpense_WithInvalidType_ShouldThrowInvalidTypeException() {
        Expense invalidTypeExpense = new Expense(null, "Valid description", BigDecimal.valueOf(10), LocalDate.now());

        when(expenseTypeValidator.isValid(invalidTypeExpense.getType())).thenReturn(true);

        assertThrows(InvalidTypeException.class, () -> expenseService.saveExpense(invalidTypeExpense));
    }
}
