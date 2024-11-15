package com.fullStack.ecommerce.graphql;


import com.fullStack.ecommerce.model.Product;
import com.fullStack.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGraphQLResolver {

    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product getProduct(@Argument Long id) {
        return productService.getProductById(id);
    }
}

