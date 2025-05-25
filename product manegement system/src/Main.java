import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    // Static variable will be automatically add unique IDs
    private static int nextID = 1;
    //Insatnce variables for each product
    private final int productID;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.productID = nextID++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
// getter methods for accessing product information
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID +
                ", Name: " + name +
                ", Price: $" + price +
                ", Quantity: " + quantity;
    }
}
// Override toString method to provide a string representation of the product @override
   
class ProductManagement {
    //the arraylist provides methods to add, edit, remove and view products
    private final List<Product> products = new ArrayList<>();
//this method add product to the collection
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully. Product ID: " + product.getProductID());
    }
// this method edits the existing product
    public void editProduct(int productID, String name, double price, int quantity) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
                System.out.println("Product edited successfully.");
                return;
            }
        }
        System.out.println("Product not found with ID: " + productID);
    }
// this method removes product from collection
    public void removeProduct(int productID) {
        products.removeIf(product -> product.getProductID() == productID);
        System.out.println("Product removed successfully.");
    }
//this method views all the products in the collection
    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("List of Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();

        int choice;

        do {
            // this is the display menu
            System.out.println("Product Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product newProduct = new Product(name, price, quantity);
                    productManagement.addProduct(newProduct);
                    break;
                case 2:
                    System.out.print("Enter product ID to edit: ");
                    int editProductID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new product price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new product quantity: ");
                    int newQuantity = scanner.nextInt();
                    productManagement.editProduct(editProductID, newName, newPrice, newQuantity);
                    break;
                case 3:
                    System.out.print("Enter product ID to remove: ");
                    int removeProductID = scanner.nextInt();
                    productManagement.removeProduct(removeProductID);
                    break;
                case 4:
                    productManagement.viewProducts();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }
}




