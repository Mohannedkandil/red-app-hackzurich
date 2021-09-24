package com.teamRed.app.User.Repo;

import com.teamRed.app.User.Model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    @NotNull List<User> findAll();
}
