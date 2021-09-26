package com.teamRed.app.User.Model;

import com.teamRed.app.Challenges.Model.Challenge;
import com.teamRed.app.Challenges.Service.ChallengeGenerator;
import com.teamRed.app.Products.Model.CartEnum;
import com.teamRed.app.Products.Model.Product;
import com.teamRed.app.Task.Model.ScanningTask;
import com.teamRed.app.Task.Model.StampTask;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Document(collection = "users")
public class User {

    @Id
    private final String email;
    private int level;
    private int experiencePoints;
    private List<Product> groceryList;
    private List<Product> productCart;
    private final List<Challenge> activeChallenges;
    private final Map<LocalDateTime, Challenge> completedChallenges;
    private String userAvatar;


    public User(String email) {
        this.email = email;
        this.level = 1;
        this.experiencePoints = 0;
        this.activeChallenges = new ArrayList<>();
        this.completedChallenges = new HashMap<>();
        this.productCart = new ArrayList<>();
        this.groceryList = new ArrayList<>();
        activeChallenges.addAll(ChallengeGenerator.generateEveryChallenge());
        this.userAvatar = "";
    }

    public User(String email, int level, int experiencePoints) {
        this.email = email;
        this.groceryList = new ArrayList<>();
        this.productCart = new ArrayList<>();
        this.activeChallenges = new ArrayList<>();
        this.completedChallenges = new HashMap<>();
        if (level <= 0)
            this.level = 1;
        else
            this.level = level;
        this.experiencePoints = Math.max(experiencePoints, 0);
        this.userAvatar = "";
    }

    @PersistenceConstructor
    public User(String email, int level, int experiencePoints, List<Product> groceryList, List<Product> productCart, List<Challenge> activeChallenges, Map<LocalDateTime, Challenge> completedChallenges, String userAvatar) {
        this.email = email;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.groceryList = groceryList;
        this.productCart = productCart;
        this.activeChallenges = activeChallenges;
        this.completedChallenges = completedChallenges;
        this.userAvatar = userAvatar;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Product> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<Product> groceryList) {
        this.groceryList = groceryList;
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public void setProductCart(List<Product> productCart) {
        this.productCart = productCart;
    }

    public boolean checkGroceryListProductExistance(String productId) {
        var flag = new AtomicBoolean(false);
        this.getGroceryList().forEach(product -> {
            if (product.getId().equals(productId)) {
                flag.set(true);
            }
        });
        return flag.get();
    }

    public boolean checkProductCartListExistance(String productId) {
        var flag = new AtomicBoolean(false);
        this.getProductCart().forEach(product -> {
            if (product.getId().equals(productId)) {
                flag.set(true);
            }
        });
        return flag.get();
    }

    public void addToGroceryList(Product product) {
        this.getGroceryList().add(product);
    }

    public void addToProductCart(Product product) {
        this.getProductCart().add(product);
    }

    public void removeProductFromList(CartEnum whatCart, Product product) {
        switch (whatCart) {
            case GROCERY_LIST:
                if (checkGroceryListProductExistance(product.getId())) {
                    groceryList.remove(product);
                }
                break;
            case SHOPPING_CART:
                if (checkProductCartListExistance(product.getId())) {
                    productCart.remove(product);
                }
                break;
            default:
                var logger = Logger.getLogger(User.class.getName());
                logger.log(Level.WARNING, "Wrong Enum Selected");
        }
    }

    public List<Challenge> getActiveChallenges() {
        return activeChallenges;
    }

    public Map<LocalDateTime, Challenge> getCompletedChallenges() {
        return completedChallenges;
    }

    public void checkProgressOnChallenges() {
        List<Challenge> expiredChallenges = new ArrayList<>();
        this.activeChallenges.forEach(challenge -> {
            if (challenge.hasExpired())
                expiredChallenges.add(challenge);
        });
        removeFromActiveChallenges(expiredChallenges);
        List<Challenge> completedChallenge = new ArrayList<>();
        this.activeChallenges.forEach(challenge -> {
            if (challenge.hasBeenCompleted()) {
                this.experiencePoints += challenge.getExperiencePoints();
                completedChallenges.put(LocalDateTime.now(), challenge);
                completedChallenge.add(challenge);
                level = (int) Math.floor((double) experiencePoints/100);
            }
        });
        removeFromActiveChallenges(completedChallenge);
    }

    private void removeFromActiveChallenges(List<Challenge> challenges) {
        List<String> challengeIds = new ArrayList<>();
        challenges.forEach(challenge -> {
            var id = challenge.getChallengeId();
            challengeIds.add(id);
            activeChallenges.remove(challenge);
        });
        challengeIds.forEach(challengeId -> {
            this.activeChallenges.add(ChallengeGenerator.generateChallengeById(challengeId));
        });

    }

    public void updateStampValidity(LocalDateTime dt) {
        var date  = dt.toLocalDate();
        checkProgressOnChallenges();
        List<StampTask> stampCompleted = new ArrayList<>();
        List<StampTask> allStampTasks = new ArrayList<>();
        activeChallenges.forEach(challenge -> {
            if (challenge.getChallengeId().equals("0"))
                challenge.getTaskList().forEach(task -> {
                    allStampTasks.add((StampTask) task);
                    if (task.isCompleted())
                        stampCompleted.add((StampTask) task);
                });
        });
        StampTask lastStamped = null;
        for (StampTask t :
                stampCompleted) {
            if (lastStamped == null) {
                lastStamped = t;
            } else {
                if (lastStamped.getCompletedTime().isBefore(t.getCompletedTime()))
                    lastStamped = t;
            }
        }
        assert lastStamped != null;
        if (date.isAfter(lastStamped.getCompletedTime())) {
            int i = 0;
            while (true) {
                if (!allStampTasks.get(i).isCompleted()) {
                    allStampTasks.get(i).setCompleted(true);
                    allStampTasks.get(i).setCompletedTime(date);
                    break;
                } else if (i >= allStampTasks.size()) {
                    break;
                }
                i++;
            }
        }
        checkProgressOnChallenges();
    }

    public void checkScannedProductValidity(Product product) {
        var scanningChallenges = activeChallenges.stream().filter(challenge -> !challenge.getChallengeId().equals("1")).collect(Collectors.toList());
        scanningChallenges.forEach(challenge -> {
            challenge.getTaskList().forEach(task -> {
                if (task instanceof ScanningTask) {
                    if (((ScanningTask) task).getProductId().equals(product.getId())) {
                        task.setCompleted(true);
                        ((ScanningTask) task).setCompletedTime(LocalDateTime.now());
                    }
                }
            });
        });
        checkProgressOnChallenges();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
