package pl.emilkulka.expensesapp.exception.expense;

public class DateFromFutureException extends IllegalStateException {
    private final String message;

    public DateFromFutureException() {
        this.message = "Data nie może być z przyszłości.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
