package pl.emilkulka.expensesapp.ExpenseTest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.emilkulka.expensesapp.exception.expense.NegativePriceException;
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

public class validExpensePriceTest {

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
    void setPriceShouldWorkCorrectly() {
        Expense expense = new Expense();

        expense.setPrice(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(100), expense.getPrice());
    }

    @Test
    void saveExpense_WithNegativePrice_ShouldThrowNegativePriceException() {
        Expense negativePriceExpense = new Expense(ExpenseType.GROCERIESANDCHEMICALS, "Valid type", BigDecimal.valueOf(-10), LocalDate.now());

        when(priceValidator.isValid(negativePriceExpense.getPrice())).thenReturn(true);

        assertThrows(NegativePriceException.class, () -> expenseService.saveExpense(negativePriceExpense));
    }

}
