package pl.emilkulka.expensesapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.emilkulka.expensesapp.model.AppUserRole;

@Getter
@Setter
@AllArgsConstructor
public class AppUserDto {
    private String userName;
    private String password;
    private String email;
    private AppUserRole userRole;
}
