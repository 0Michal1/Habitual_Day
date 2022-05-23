package com.habitualday.habitual_day.services;

import com.habitualday.habitual_day.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AuthService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user-> new User(
                     user.getUsername(),
                     user.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getRole()))))
                .orElseThrow(()->new UsernameNotFoundException("No user with username " + username));
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository =userRepository;
    }
}
