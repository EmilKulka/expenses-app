package pl.emilkulka.expensesapp.UserTest;

import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.model.AppUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class validEmailTest {

    @Test
    public void isEmailValid() {
        AppUser user = new AppUser();

        user.setEmail("xyz@gmail.com");

        assertEquals("xyz@gmail.com", user.getEmail());
    }

    @Test
    public void isEmailFormatValid() {
        AppUser user = new AppUser();

        user.setEmail("xyz@gmail.com");

        assertThat(user.getEmail())
                .matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

}
