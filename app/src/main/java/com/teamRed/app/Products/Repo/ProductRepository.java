package com.teamRed.app.Products.Repo;

import com.teamRed.app.Products.Model.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @NotNull Optional<Product> findById(String Id);

}
