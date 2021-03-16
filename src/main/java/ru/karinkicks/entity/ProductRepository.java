package ru.karinkicks.entity;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void onInit() {
        Product p1 = new Product(1L, "Продукт 1", 10);
        Product p2 = new Product(2L, "Продукт 2", 11);
        Product p3 = new Product(3L, "Продукт 3", 12);
        Product p4 = new Product(4L, "Продукт 4", 13);
        Product p5 = new Product(5L, "Продукт 5", 14);
        products=new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
    }

    public List<Product> getProducts(){
        return products;
    }

    public Optional<Product> getProductById(Long id){
        Optional<Product> product = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return product;
    }
}
