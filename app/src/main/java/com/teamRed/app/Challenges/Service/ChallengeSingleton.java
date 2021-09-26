package com.teamRed.app.Challenges.Service;

import com.teamRed.app.Products.Model.Product;
import com.teamRed.app.Products.Repo.ProductRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeSingleton implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private static ChallengeSingleton instance;
    private final ProductRepository productRepository;

    public ChallengeSingleton(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ChallengeSingleton.applicationContext = applicationContext;
    }

    public static ChallengeSingleton getInstance() {
        if (instance == null) {
            instance = applicationContext.getBean(ChallengeSingleton.class);
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
