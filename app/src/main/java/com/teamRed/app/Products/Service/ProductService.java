package com.teamRed.app.Products.Service;

import com.teamRed.app.Products.Repo.ProductRepository;
import com.teamRed.app.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean addProductToGroceryList(User user, String productId) {
        if (user.checkGroceryListProductExistance(productId))
            return false;
        var product = productRepository.findById(productId);
        if (product.isPresent()) {
            user.addToGroceryList(product.get());
            return true;
        }
        return false;
    }

    public boolean addProductToCart(User user, String productId) {
        if (user.checkProductCartListExistance(productId))
            return false;
        var product = productRepository.findById(productId);
        if (product.isPresent()) {
            user.addToProductCart(product.get());
            return true;
        }
        return false;
    }
}
