package com.fullStack.ecommerce.service;

import com.fullStack.ecommerce.model.Product;
import com.fullStack.ecommerce.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @PostConstruct
    private void loadData() {
        Product[] products = new Product[] {
                Product.builder().name("Product 1").description("Product 1 Description").price(700.0).build(),
                Product.builder().name("Product 2").description("Product 2 Description").price(1200.0).build(),
                Product.builder().name("Product 3").description("Product 3 Description").price(450.0).build(),
                Product.builder().name("Product 4").description("Product 4 Description").price(980.0).build()
        };
        for (Product product : products) {
            createProduct(product);
        }
    }
}

