import java.util.ArrayList;
import java.util.Scanner;

class Food {
    String name;
    double price;

    Food(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Main {

    static Scanner in = new Scanner(System.in);
    static ArrayList<Food> menu = new ArrayList<>();
    static double total = 0;

    public static void main(String[] args) {

        menu.add(new Food("Burger", 500));
        menu.add(new Food("Pizza", 1000));
        menu.add(new Food("Fries", 200));
        menu.add(new Food("Juice", 150));

        int choice;

        do {
            System.out.println("\n1. Show Menu");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Order Food");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    orderFood();
                    break;
                case 5:
                    generateBill();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void showMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". "
                    + menu.get(i).name + " Rs. "
                    + menu.get(i).price);
        }
    }

    static void addItem() {
        in.nextLine();

        System.out.print("Enter item name: ");
        String name = in.nextLine();

        System.out.print("Enter price: ");
        double price = in.nextDouble();

        if (price > 0) {
            menu.add(new Food(name, price));
            System.out.println("Item added!");
        } else {
            System.out.println("Invalid price!");
        }
    }

    static void removeItem() {
        showMenu();

        System.out.print("Enter item number to remove: ");
        int n = in.nextInt();

        if (n >= 1 && n <= menu.size()) {
            menu.remove(n - 1);
            System.out.println("Item removed!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    static void orderFood() {
        showMenu();

        System.out.print("Enter item number: ");
        int n = in.nextInt();

        if (n >= 1 && n <= menu.size()) {
            System.out.print("Enter quantity: ");
            int qty = in.nextInt();

            if (qty > 0) {
                double amount = menu.get(n - 1).price * qty;
                total += amount;

                System.out.println("Item: "
                        + menu.get(n - 1).name);
                System.out.println("Amount: Rs. " + amount);
            } else {
                System.out.println("Invalid quantity!");
            }
        } else {
            System.out.println("Invalid item!");
        }
    }

    static void generateBill() {
        double gst = total * 0.05;

        System.out.println("\n----- FINAL BILL -----");
        System.out.println("Subtotal: Rs. " + total);
        System.out.println("GST (5%): Rs. " + gst);
        System.out.println("Total: Rs. " + (total + gst));
    }
}
