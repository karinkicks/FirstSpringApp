package ru.karinkicks.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.karinkicks.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value ="prototype")
public class Cart {

    public List<Product> productsCart = new ArrayList<>();

    public void addProduct(Product product){
        productsCart.add(product);
    }

    public void deleteProduct(Product product){
        productsCart.remove(product);
    }

    @Override
    public String toString() {
        String productStr = null;
        for (Product product : productsCart) {
            productStr = product.getId() + " "
                    + product.getName() + " "
                    + product.getCost() + "\n";
        }
        return productStr;
    }
}
