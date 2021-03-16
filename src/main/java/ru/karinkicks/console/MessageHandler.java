package ru.karinkicks.console;

import org.springframework.stereotype.Service;
import ru.karinkicks.cart.Cart;

import java.util.Locale;

@Service
public class MessageHandler {

    private final Cart cart;

    public MessageHandler(Cart cart){
        this.cart = cart;
    }

    public void process(String msg){

        String [] message = msg.split("\s");

        switch (message[0].toUpperCase(Locale.ROOT)){
            case "SHOW_CART":
                cart.showProductCart();
                break;
            case "SHOW_REPO":
                cart.showAvailableProduct();
                break;
            case "ADD":
                cart.addProduct(Long.valueOf(message[1]));
                break;
            case "DELETE":
                cart.deleteProduct(Long.valueOf(message[1]));
                break;
            default:
                System.out.println("Введена неверная команда");
                break;
        }
    }
}
