package com.habitualday.habitual_day.services.defaults;

import com.habitualday.habitual_day.controllers.register.RegisterModel;
import com.habitualday.habitual_day.entities.User;
import com.habitualday.habitual_day.repositories.UserRepository;
import com.habitualday.habitual_day.services.intefaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void addNewUser(RegisterModel registerModel) {
        userRepository.save(User.builder()
                        .email(registerModel.getEmail())
                        .username(registerModel.getUsername())
                        .password(passwordEncoder.encode(registerModel.getPassword()))
                        .role("USER")
                .build());
    }

}
