package com.teamRed.app.Products.Controller;

import com.teamRed.app.Products.Service.ProductService;
import com.teamRed.app.User.Model.User;
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

    @GetMapping("/{userEmail}/groceryListAddition/{productId}")
    public ResponseEntity<Boolean> addToGroceryList(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            if (productService.addProductToGroceryList(user.get(), productId))
                return ResponseEntity.ok(true);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userEmail}/cartListAddition/{productId}")
    public ResponseEntity<Boolean> addProductToCart(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            if (productService.addProductToCart(user.get(), productId))
                return ResponseEntity.ok(true);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductFromId(@PathVariable("productId")String id) {
        if (productService.getProductFromId(id).isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productService.getProductFromId(id).get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userEmail}/groceryListAddition/{productId}/increment")
    public ResponseEntity<Boolean> incrementInGroceryList(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            if (productService.addProductToGroceryList(user.get(), productId))
                return ResponseEntity.ok(true);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userEmail}/groceryListCount/{productId}")
    public ResponseEntity<Integer> countInGroceryList(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            User u = user.get();
            return ResponseEntity.ok((int) u.getGroceryList().stream().filter(product -> product.getId().equals(productId)).count());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userEmail}/cartListAddition/{productId}/increment")
    public ResponseEntity<Boolean> increaseProductToCart(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            if (productService.addProductToCart(user.get(), productId))
                return ResponseEntity.ok(true);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userEmail}/cartListCount/{productId}")
    public ResponseEntity<Integer> countInCartList(@PathVariable("userEmail") String userEmail, @PathVariable("productId") String productId) {
        var user = userService.getUserByEmail(userEmail);
        if (user.isPresent()) {
            User u = user.get();
            return ResponseEntity.ok((int) u.getProductCart().stream().filter(product -> product.getId().equals(productId)).count());
        }
        return ResponseEntity.badRequest().build();
    }
}
