package pl.emilkulka.expensesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.emilkulka.expensesapp.dto.AppUserDto;
import pl.emilkulka.expensesapp.model.AppUser;
import pl.emilkulka.expensesapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser save(AppUserDto appUserDto) {
        AppUser appUser = new AppUser(appUserDto.getUserName(), passwordEncoder.encode(appUserDto.getPassword()), appUserDto.getEmail(), appUserDto.getUserRole());
        return userRepository.save(appUser);
    }

    public AppUser findByUsername(String username) {
        return userRepository.findByUserName(username);
    }


}
