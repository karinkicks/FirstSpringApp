package ru.karinkicks.cart;

import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.karinkicks.entity.Product;
import ru.karinkicks.entity.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value ="prototype")
public class Cart {

    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    private List<Product> productsCart = new ArrayList<>();

    public void addProduct(Long id){
        Optional<Product> p = productRepository.getProductById(id);
        if(p.isPresent()){
            productsCart.add(p.get());
            System.out.println("Продукт номер " + id + " добавлен в корзину");
        }else {
            System.out.println("Такого продукта нет");
        }
    }

    public void deleteProduct(Long id){
        Optional<Product> product = productsCart.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if(product.isPresent()){
            productsCart.remove(product.get());
            System.out.println("Продукт номер " + id + " удален из корзины");
        }else {
            System.out.println("Такого продукта нет");
        }
    }

    public void showProductCart(){
        System.out.println(productsCart);
    }

    public void showAvailableProduct(){
        System.out.println(productRepository.getProducts());
    }
}
