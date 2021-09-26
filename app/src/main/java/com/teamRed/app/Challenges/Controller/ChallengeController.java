package com.teamRed.app.Challenges.Controller;

import com.teamRed.app.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final UserService userService;

    @Autowired
    public ChallengeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/active/{email}")
    public ResponseEntity<List<ChallengeDTO>> getActiveChallenges(@PathVariable("email") String email) {
        if (userService.getUserByEmail(email).isPresent()) {
            var activeChallenges = userService.getUserByEmail(email).get().getActiveChallenges();
            List<ChallengeDTO> dtos = new ArrayList<>();
            activeChallenges.forEach(challenge -> dtos.add(new ChallengeDTO(challenge)));
            return ResponseEntity.ok(dtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/completed/{email}")
    public ResponseEntity<Map<LocalDateTime, ChallengeDTO>> getCompletedChallenges(@PathVariable("email") String email) {
        if (userService.getUserByEmail(email).isPresent()) {
            var completedChallenges = userService.getUserByEmail(email).get().getCompletedChallenges();
            Map<LocalDateTime, ChallengeDTO> dtos = new HashMap<>();
            completedChallenges.forEach((k, v) -> dtos.put(k, new ChallengeDTO(v)));
            return ResponseEntity.ok(dtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/stamp/{email}/{date}")
    public void checkStampValidityAndUpdate(@PathVariable("email") String email, @PathVariable("date") String date) {
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        userService.updateStampChallenge(email, dt);
        if (userService.getUserByEmail(email).isPresent())
            userService.saveUser(userService.getUserByEmail(email).get());
    }

    @GetMapping("/scan/{email}/{productId}")
    public void checkScannedProductValidity(@PathVariable("email") String email ,@PathVariable("productId") String productId) {
        userService.updateScannedChallenges(email, productId);
        if (userService.getUserByEmail(email).isPresent())
            userService.saveUser(userService.getUserByEmail(email).get());
    }

}
