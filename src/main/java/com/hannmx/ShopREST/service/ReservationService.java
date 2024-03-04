package com.hannmx.ShopREST.service;

import com.hannmx.ShopREST.model.Product;
import com.hannmx.ShopREST.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void reserveProduct(Product product, int quantity) {
        // Получаем текущее количество товара на складе
        int availableQuantity = product.getQuantity();

        // Проверяем, достаточно ли товара на складе для резервирования
        if (availableQuantity >= quantity) {
            // Уменьшаем количество доступного товара на складе
            product.setQuantity(availableQuantity - quantity);

            // Сохраняем изменения в базе данных
            productRepository.save(product);

            // Логика резервирования товара, например, добавление информации о резерве в базу данных
        } else {
            throw new RuntimeException("Недостаточно товара на складе для резервирования");
        }
    }

}
