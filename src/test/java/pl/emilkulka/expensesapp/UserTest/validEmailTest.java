package pl.emilkulka.expensesapp.UserTest;

import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.exception.user.EmailFormatException;
import pl.emilkulka.expensesapp.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class validEmailTest {

    @Test
    public void isEmailValid() {
        User user = new User();

        user.setEmail("xyz@gmail.com");

        assertEquals("xyz@gmail.com", user.getEmail());
    }

    @Test
    public void isEmailFormatValid() {
        User user = new User();

        user.setEmail("xyz@gmail.com");

        assertThat(user.getEmail())
                .matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

}
