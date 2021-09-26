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
import java.util.HashSet;
import java.util.Set;

@Component
public class JSONProductLoader implements ApplicationRunner {

    private final String PRODUCT_FOLDER_PATH = "app/src/main/resources/static/products/";
    private final ProductRepository productRepository;

    @Autowired
    public JSONProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        String filename="100105400000.json";
//        Path pathToFile = Paths.get(filename);
//        System.out.println(pathToFile.toAbsolutePath());
        System.out.println("Hello");
        var files = readAllProducts();
        System.out.println("Files Names Read");
        readAndInsertAllFiles(files);
    }

    private void readAndInsertAllFiles(Set<String> files) {
        files.forEach(file -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Product product = objectMapper.readValue(Paths.get(PRODUCT_FOLDER_PATH, file).toFile(), Product.class);
                productRepository.insert(product);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
