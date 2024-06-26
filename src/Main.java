import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner Input = new Scanner(System.in);
        while (true) {
            System.out.println("========================");
            System.out.println("type 'a' to add inventory item.");
            System.out.println("type 'b' to search inventory item.");
            System.out.println("type 'c' to update inventory item.");
            System.out.println("type 'd' to delete inventory item.");
            System.out.println("type 'e' to add table.");
            System.out.println("type 'f' to delete table.");
            System.out.println("type 'g' to add menu item.");
            System.out.println("type 'h' to search menu item.");
            System.out.println("type 'i' to delete menu item.");
            System.out.println("type 'j' to update menu item's price.");
            System.out.println("type 'k' to make ordering.");
            System.out.println("type 'l' to see daily sale report.");
            System.out.println("type 'z' to exit program.");

            char Choice = Input.nextLine().charAt(0);
            if (Choice == 'a') {
                restaurant.addInventoryItem();
            } else if (Choice == 'b') {
                System.out.println("Enter name to search");
                String name= Input.nextLine();
                restaurant.searchInventoryItemByName(name);
            } else if (Choice == 'c') {
                restaurant.updateInventoryItem();
            }else if (Choice=='d'){
                restaurant.deleteInventoryItem();
            }else if (Choice=='e') {
                restaurant.crateTable();
            }else if (Choice=='f') {
                restaurant.deleteTable();
            }else if (Choice=='g') {
                restaurant.addMenuItem();
            }else if (Choice=='h') {
                System.out.println("Enter name to search");
                String name= Input.nextLine();
                restaurant.searchMenuItemByName(name);
            }else if (Choice=='i') {
                restaurant.deleteMenuItem();
            }else if (Choice=='j') {
                restaurant.updateMenuItemPrize();
            }else if (Choice=='k') {
                restaurant.ordering();
            }else if (Choice=='l') {
                restaurant.dailySaleReport();

            }else if (Choice=='z') {

                break;

            }
        }

    }

}

