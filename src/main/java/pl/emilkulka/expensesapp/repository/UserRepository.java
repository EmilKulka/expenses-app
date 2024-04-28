package pl.emilkulka.expensesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emilkulka.expensesapp.model.AppUser;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);

    AppUser findByUserName(String username);
}
