package ru.karinkicks.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.karinkicks.cart.Cart;
import ru.karinkicks.entity.ProductRepository;

@Component
public class Runner implements CommandLineRunner {
    private final ProductRepository productRepository;
    private Cart cart;
    private final ApplicationContext context;

    public Runner(ProductRepository productRepository,
                  Cart cart,
                  ApplicationContext context) {
        this.productRepository = productRepository;
        this.cart = cart;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        cart.addProduct(productRepository.getProductId(0));
        System.out.println(cart.toString());
        cart= (Cart) context.getBean("cart");
        //проверяем, что создалась новая пустая корзина
        System.out.println(cart.toString());
    }
}
