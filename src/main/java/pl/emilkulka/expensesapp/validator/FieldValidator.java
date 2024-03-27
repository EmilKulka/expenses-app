package pl.emilkulka.expensesapp.validator;

public interface FieldValidator<T> {
    boolean isValid(T value);
}
