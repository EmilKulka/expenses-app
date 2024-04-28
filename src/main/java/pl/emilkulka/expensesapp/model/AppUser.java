package pl.emilkulka.expensesapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "user_name")})
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String userName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private AppUserRole userRole;
    @OneToMany(mappedBy = "user")
    List<Expense> expenseList;

    public AppUser(String userName, String password, String email, AppUserRole userRole) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

}

