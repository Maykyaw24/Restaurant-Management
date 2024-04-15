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
            System.out.println("type 'z' to exit program.");

            char Choice = Input.next().charAt(0);
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
            }else if (Choice=='z'){

                break;


            }


        }
    }
}

