package com.teamRed.app.User.Controller;

import com.teamRed.app.User.Model.User;
import com.teamRed.app.User.Model.UserDTO;
import com.teamRed.app.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email).map(user -> ResponseEntity.ok(new UserDTO(user))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/create/{email}")
    public ResponseEntity<Boolean> createUser(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.createNewUser(email));
    }

    @GetMapping("/setAvatar/{email}/{avatarUrl}")
    public void setUserAvatar(@PathVariable("email") String email, @PathVariable("avatarUrl") String avatarUrl) {
        var u = userService.getUserByEmail(email);
        if (u.isPresent()) {
            User user = u.get();
            user.setUserAvatar(avatarUrl);
        }
    }


}
