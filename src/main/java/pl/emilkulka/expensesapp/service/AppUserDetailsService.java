package pl.emilkulka.expensesapp.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.emilkulka.expensesapp.model.AppUser;
import pl.emilkulka.expensesapp.repository.UserRepository;
import pl.emilkulka.expensesapp.security.AppUserDetails;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(String.format("User %s not found.   ", username));
        }
        return new AppUserDetails(appUser);
    }
}
