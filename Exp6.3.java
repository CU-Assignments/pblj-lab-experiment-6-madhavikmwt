import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Comparator;
import java.util.Optional;

class Product {
    String name;
    String category;
    double price;

    // Constructor
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Display method
    public void display() {
        System.out.println(name + " - " + category + " - $" + price);
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        // Step 1: Create Product List
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("T-shirt", "Clothing", 20),
                new Product("Jeans", "Clothing", 40),
                new Product("Sneakers", "Footwear", 100),
                new Product("Boots", "Footwear", 150),
                new Product("Headphones", "Electronics", 200)
        );

        // Step 2: Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(product -> product.category));

        // Step 3: Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        product -> product.category,
                        Collectors.maxBy(Comparator.comparingDouble(product -> product.price))
                ));

        // Step 4: Calculate the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(product -> product.price));

        // Display Results
        System.out.println("Grouped Products by Category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList.size() + " products");
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, productOpt) -> 
            productOpt.ifPresent(product -> System.out.println(category + " -> " + product.name + " ($" + product.price + ")"))
        );

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
//Madhavi kumawat_22BCS12660
