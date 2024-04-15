import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private ArrayList<InventoryItem> inventoryItems;
    private ArrayList<Table> tables;
    private ArrayList<MenuItem>menuItems;
    private InputScanner input;

    public Restaurant() {
        this.input = new InputScanner();
        this.inventoryItems = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.menuItems=new ArrayList<>();
    }

    public void addInventoryItem() {
        int id = this.inventoryItems.size() + 1;
        try {
            String name = this.input.readStringInput("Enter Inventory Item name.");
            double count = this.input.readDoubleInput("Enter Inventory Item count");

            if (count < 0) {
                System.out.println("try again");
               return;
            }


            InventoryItem inventoryItem = new InventoryItem(id, name,count);
            this.inventoryItems.add(inventoryItem);
            inventoryItem.describeInventoryItem();
        }catch (NumberFormatException e){
            System.out.println("Invalid input");
        }
   }

    public InventoryItem searchInventoryItemByName(String name) {

        for (InventoryItem item : this.inventoryItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Inventory item found:");
                item.describeInventoryItem();
              return item;
            }
        }

            System.out.println("Inventory item does not exist.");
        return null;

    }
    public void updateInventoryItem() {
        String inventoryItemName = this.input.readStringInput("Enter inventory item name to update.");
        InventoryItem currInventoryItem=this.searchInventoryItemByName(inventoryItemName);
        if(currInventoryItem!=null){
            double newCount=this.input.readDoubleInput("Enter new count");
            currInventoryItem.setCount(newCount);
        }
        }


        public void deleteInventoryItem() {
        String itemName=this.input.readStringInput("Enter item Name to delete");
        InventoryItem targetInventoryItem=this.searchInventoryItemByName(itemName);
        this.inventoryItems.remove(targetInventoryItem);
    }

    public void crateTable() {
        int id = this.tables.size() + 1;
        int tableSize = this.input.readIntInput("Enter table's size");
        Table table = new Table(id, tableSize);
        this.tables.add(table);
        table.describeTable();
    }

    public void deleteTable() {
        int tableIdToDelete = this.input.readIntInput("Enter table ID to delete:");
        boolean found = false;
        for (int i = 0; i < this.tables.size(); i++) {
            if (this.tables.get(i).getId() == tableIdToDelete) {
                this.tables.remove(i);
                System.out.println("Table removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Table NOT found!");
        }
    }
    public void addMenuItem(){
            int id = this.menuItems.size() + 1;
            String menuName = this.input.readStringInput("Enter menu Item name");
            double prize = this.input.readDoubleInput("Enter Inventory Item count");
            MenuItem menuItem = new MenuItem(id, menuName, prize);
            this.menuItems.add(menuItem);
            menuItem.describeMenuItem();
        }





    }



















