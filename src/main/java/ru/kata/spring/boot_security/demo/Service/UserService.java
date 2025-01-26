package ru.kata.spring.boot_security.demo.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public User saveUser(User user);
    public UserDetails loadUserByUsername(String username);
    public User findBbyUsername(String username);
    public List<User> getAllUser();
    public Optional<User> findUserById(Long id);
    public void updateUser(User user);
    public void deleteUserById(Long id);
}
