package com.teamRed.app.Products.Controller;

import com.teamRed.app.Products.Service.ProductService;
import com.teamRed.app.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public ProductController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("{userEmail}/groceryListAddition/{productId}")
    public ResponseEntity<Boolean> addToGroceryList(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            productService.addProductToGroceryList(user.get(), productId);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }
}
