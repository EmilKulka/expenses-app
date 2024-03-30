package pl.emilkulka.expensesapp.exception.expense;

public class InvalidTypeException extends IllegalStateException{

    private final String message;

    public InvalidTypeException() {
        this.message = "Niepoprawny type wydatku.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
