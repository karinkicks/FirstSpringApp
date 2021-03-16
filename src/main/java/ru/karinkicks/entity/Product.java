package ru.karinkicks.entity;

public class Product {
    private Long id;
    private String name;
    private double cost;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Product(Long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
