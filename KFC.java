import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KFCBillingCounter {
    private static Map<Integer, String> menu = new HashMap<>();
    private static int tokenNumber = 1;
    private static int counter = 1;

    public static void main(String[] args) {
        addMenuItems();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to KFC Billing Counter " + counter);
            System.out.println("1. Place Order");
            System.out.println("2. Payment");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    placeOrder(scanner);
                    break;
                case 2:
                    payment(scanner);
                    break;
                case 3:
                    System.out.println("Thank you for visiting KFC!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void addMenuItems() {
        menu.put(1, "Chicken Bucket - ₹500");
        menu.put(2, "Chicken Sandwich - ₹200");
        menu.put(3, "Fries - ₹100");
        menu.put(4, "Coke - ₹50");
    }

    private static void placeOrder(Scanner scanner) {
        System.out.println("Menu:");
        for (Map.Entry<Integer, String> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.print("Enter the item number you want to order: ");
        int itemNumber = scanner.nextInt();
        if (menu.containsKey(itemNumber)) {
            System.out.println("Order placed successfully. Your token number is " + tokenNumber);
            tokenNumber++;
            System.out.println("Please wait...");
        } else {
            System.out.println("Invalid item number. Please try again.");
        }
    }

    private static void payment(Scanner scanner) {
        System.out.print("Enter your token number: ");
        int token = scanner.nextInt();
        if (token < tokenNumber) {
            System.out.println("Payment successful. Your order will be ready soon.");
        } else {
            System.out.println("Invalid token number. Please try again.");
        }
    }
}
