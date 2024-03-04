package com.hannmx.ShopREST.service;

import com.hannmx.ShopREST.model.Product;
import com.hannmx.ShopREST.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void processPayment(Product product, double amount) {
        // Получаем текущее количество товара на складе
        int availableQuantity = product.getQuantity();

        // Проверяем, достаточно ли товара на складе для оплаты
        if (availableQuantity >= 1) {
            // Уменьшаем количество доступного товара на складе
            product.setQuantity(availableQuantity - 1);

            // Выполняем платеж (просто уменьшим счет товара на 1)

            // Сохраняем изменения в базе данных
            productRepository.save(product);

            // Логика обработки платежа, например, запись информации о платеже в базу данных
        } else {
            throw new RuntimeException("Недостаточно товара на складе для выполнения платежа");
        }
    }
}