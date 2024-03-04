package com.hannmx.ShopREST.service;
import com.hannmx.ShopREST.model.Product;
import com.hannmx.ShopREST.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

}

