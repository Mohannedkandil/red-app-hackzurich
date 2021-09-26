package com.teamRed.app.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamRed.app.Products.Model.Product;
import com.teamRed.app.Products.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JSONProductLoader implements ApplicationRunner {

    private final String PRODUCT_FOLDER_PATH = "app/src/main/resources/static/products/";
    private final ProductRepository productRepository;
    private final String TICINO_AVAILABILITY = "gmti";

    @Autowired
    public JSONProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        var files = readAllProducts();
        readAndInsertAllFiles(files);
    }

    private void readAndInsertAllFiles(Set<String> files) {
        final List<Product> products = new ArrayList<>();
        files.forEach(file -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Product product = objectMapper.readValue(Paths.get(PRODUCT_FOLDER_PATH, file).toFile(), Product.class);
                products.add(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        var prods = products.stream().filter(product -> product.getRegionalAvailibility().getAvailibilityInTicino() != null).collect(Collectors.toList());
        prods.forEach(productRepository::insert);
    }

    private Set<String> readAllProducts() {
        var files = new HashSet<String>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(PRODUCT_FOLDER_PATH))) {
            int i = 0;
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    files.add(path.getFileName()
                            .toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}
