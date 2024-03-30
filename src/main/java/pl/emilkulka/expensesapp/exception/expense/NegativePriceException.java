package pl.emilkulka.expensesapp.exception.expense;

public class NegativePriceException extends IllegalStateException{
    private final String message;

    public NegativePriceException() {
        this.message = "Koszt nie może być ujemny.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
