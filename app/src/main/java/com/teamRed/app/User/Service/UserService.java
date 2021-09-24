package com.teamRed.app.User.Service;

import com.teamRed.app.User.Model.User;
import com.teamRed.app.User.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        User u;
        try {
            u = userRepository.findByEmail(email);
        } catch (IncorrectResultSizeDataAccessException e) {
            var logger = Logger.getLogger(UserService.class.getName());
            logger.log(Level.SEVERE, e.getMessage());
            return Optional.empty();
        }
        if (u != null)
            return Optional.of(u);
        return Optional.empty();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
