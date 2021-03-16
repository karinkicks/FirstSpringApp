package ru.karinkicks.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.karinkicks.cart.Cart;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class ConsoleApp implements CommandLineRunner {
    private final MessageHandler messageHandler;

    public ConsoleApp(MessageHandler messageHandler){
        this.messageHandler=messageHandler;
    }

    @Override
    public void run(String... args) {
        System.out.println("Добро пожаловать в он-лайн магазин КонсоМагаз");
        System.out.println("Введите SHOW_REPO для просмотра доступных товаров");
        System.out.println("Введите SHOW_CART для просмотра товаров в корзине");
        System.out.println("Введите ADD и номер товара для добавления товара в корзину");
        System.out.println("Введите DELETE и номер товара для удаления товара из корзины");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                String message = bufferedReader.readLine();
                if(bufferedReader.equals("EXIT")){
                    System.out.println("Вы вышли из магазина");
                    break;
                }
                messageHandler.process(message);
            }
        }catch (Exception e){
            throw new RuntimeException("SWW");
        }
    }
}
