package pl.emilkulka.expensesapp.exception.expense;

public class DescriptionLimitException extends IllegalStateException{

    private final String message;

    public DescriptionLimitException() {
        this.message = "Opis może zawierać tylko 100 znaków.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
