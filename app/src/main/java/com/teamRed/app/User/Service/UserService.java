package com.teamRed.app.User.Service;

import com.teamRed.app.Products.Repo.ProductRepository;
import com.teamRed.app.Products.Service.ProductService;
import com.teamRed.app.User.Model.User;
import com.teamRed.app.User.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final ProductService productService;


    @Autowired
    public UserService(UserRepository userRepository, ProductService productService) {
        this.userRepository = userRepository;
        this.productService = productService;
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
        userRepository.insert(user);
    }

    public Boolean createNewUser(String email) {
        User u = new User(email);
        updateUser(u);
        return true;
    }

    public void updateStampChallenge(String email, LocalDateTime dt) {
        if (getUserByEmail(email).isPresent()) {
            getUserByEmail(email).get().updateStampValidity(dt);
        }
    }

    public void updateScannedChallenges(String email, String productId) {
        if (getUserByEmail(email).isPresent()) {
            User u = getUserByEmail(email).get();
            var prod = productService.getProductFromId(productId);
            if (prod.isPresent()) {
                u.checkScannedProductValidity(prod.get());
            }
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
