import java.time.LocalDate;
import java.util.ArrayList;

public class Restaurant {
    private ArrayList<InventoryItem> inventoryItems;
    private ArrayList<Table> tables;
    private ArrayList<MenuItem> menuItems;
    private ArrayList<OrderItem> orderItems;
    private ArrayList<Order> orders;
    private InputScanner input;
    private ArrayList<DailyReport>dailyReports;

    public Restaurant() {
        this.input = new InputScanner();
        this.inventoryItems = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.menuItems = new ArrayList<>();
        this.orderItems = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.dailyReports= new ArrayList<>();
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
            InventoryItem inventoryItem = new InventoryItem(id, name, count);
            this.inventoryItems.add(inventoryItem);
            inventoryItem.describeInventoryItem();
        } catch (NumberFormatException e) {
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
        try {
            String inventoryItemName = this.input.readStringInput("Enter inventory item name to update.");
            InventoryItem currInventoryItem = this.searchInventoryItemByName(inventoryItemName);
            if (currInventoryItem != null) {
                String newName = this.input.readStringInput("Enter new name");
                currInventoryItem.setName(newName);
                double newCount = this.input.readDoubleInput("Enter new count");
                if (newCount < 0) {
                    System.out.println("try again");
                    return;
                }
                currInventoryItem.setCount(newCount);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }


    public void deleteInventoryItem() {
        String itemName = this.input.readStringInput("Enter item Name to delete");
        InventoryItem targetInventoryItem = this.searchInventoryItemByName(itemName);
        this.inventoryItems.remove(targetInventoryItem);
        System.out.println(itemName + " is deleted");
    }


    public void showAllInventory() {
        if (this.inventoryItems.isEmpty()) {
            System.out.println("There are no InventoryItems.");
            System.out.println("------------------------------------------");
            return;
        }
        for (InventoryItem currInventory : this.inventoryItems) {
            currInventory.describeInventoryItem();
        }
    }


    public void crateTable() {
        try {
            int id = this.tables.size() + 1;
            int tableSize = this.input.readIntInput("Enter table's size");
            Table table = new Table(id, tableSize);
            this.tables.add(table);
            table.describeTable();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    public Table searchTableByID(int id) {

        for (Table ID : this.tables) {
            if (ID.getId() == id) {
                System.out.println("Menu item found:");
                ID.describeTable();
            }
            return ID;
        }
        System.out.println("Menu item does not exist.");
        return null;
    }

    public void deleteTable() {
        try {
            int tableIdToDelete = this.input.readIntInput("Enter table ID to delete:");
            Table targetTable = this.searchTableByID(tableIdToDelete);
            this.tables.remove(targetTable);
            System.out.println("Table number" + tableIdToDelete + " is deleted");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }

    }


    public boolean inventoryItemExit(String menuName) {
        //String menuName = this.input.readStringInput("Enter Menu Item Name");
        for (InventoryItem item : this.inventoryItems) {
            if (item.getName().equalsIgnoreCase(menuName)) {
                return true;
            }
        }
        return false;
    }


    public void addMenuItem() {
        try {
            // int id = this.menuItems.size() + 1;
            // if (inventoryItemExit()) {
            String menuName = this.input.readStringInput("Enter Menu Item Name");
            //  double prize = this.input.readDoubleInput("Enter Item prize");
            if (inventoryItemExit(menuName)) {
                int id = this.menuItems.size() + 1;
                double prize = this.input.readDoubleInput("Enter Item prize");
                if (prize < 0) {
                    System.out.println("try again!!");
                    return;
                }
                MenuItem menuItem = new MenuItem(id, menuName, prize);
                this.menuItems.add(menuItem);
                menuItem.describeMenuItem();
            } else {
                System.out.println("Item does not exist in inventory, so you can't add it to Menu");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }


    public MenuItem searchMenuItemByName(String name) {

        for (MenuItem item : this.menuItems) {
            if (item.getMenuName().equalsIgnoreCase(name)) {
                System.out.println("Menu item found:");
                item.describeMenuItem();
                return item;
            }
        }
        System.out.println("Menu item does not exist.");
        return null;
    }


    public void updateMenuItemPrize() {
        try {
            String menuName = this.input.readStringInput("Enter inventory item name to update.");
            MenuItem currMenu = this.searchMenuItemByName(menuName);
            if (currMenu != null) {
                double newPrize = this.input.readDoubleInput("Enter new Prize");
                if (newPrize < 0) {
                    System.out.println("try again");
                    return;
                }
                currMenu.setPrize(newPrize);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }


    public void deleteMenuItem() {
        String itemName = this.input.readStringInput("Enter menu item Name to delete");
        MenuItem targetMenu = this.searchMenuItemByName(itemName);
        this.menuItems.remove(targetMenu);
        System.out.println(itemName + " is deleted");
    }


    public void showAllMenuItem() {
        if (this.menuItems.isEmpty()) {
            System.out.println("There are no menu item");
            System.out.println("------------------------------------------");
            return;
        }
        for (MenuItem currMenu : this.menuItems) {
            currMenu.describeMenuItem();
        }
    }

    public boolean acceptableQuantity(String orderName, double orderQuantity) {
        for (InventoryItem item : this.inventoryItems) {
            if (item.getName().equalsIgnoreCase(orderName)) {
                for (InventoryItem Item : this.inventoryItems) {
                    if (Item.getCount() >= orderQuantity) {
                        System.out.println("quantity can be accepted.");
                        // } else System.out.println("quantity not enough");
                    }
                }
                    return true;
                }
                return true;
            }
            return false;
        }

    public void reduceInventoryCount(String orderName,double orderQuantity) {
        for (InventoryItem item : this.inventoryItems) {
            if (item.getName().equalsIgnoreCase(orderName)) {
                    double inventoryItemLeft = item.getCount() - orderQuantity;
                    item.setCount(inventoryItemLeft) ;
                    }
                }
            }



    public void makeAnOrder() {
        try {
            while (true) {
                String orderName = this.input.readStringInput("Enter item Name to order or enter 'finish' to stop");
                if (orderName.equalsIgnoreCase("finish")) {
                    break;
                } else {
                    this.showAllMenuItem();
                    int id = this.orders.size() + 1;
                    // String orderName = this.input.readStringInput("Enter item Name to order or enter 'finish' to stop");
                    MenuItem targetMenu = this.searchMenuItemByName(orderName);
                    String remark = null;
                    double orderQuantity = 0;
                    if (targetMenu != null) {
                        orderQuantity = this.input.readDoubleInput("Enter quantity");
                        if (orderQuantity < 0) {
                            System.out.println("try again!!");
                            return;
                        }
                        if (acceptableQuantity(orderName, orderQuantity)) {
                            remark = this.input.readStringInput("Enter remark");
                            reduceInventoryCount(orderName, orderQuantity);
                            double price = 0;
                            for(MenuItem mi: this.menuItems) {
                                if(mi.getMenuName().equalsIgnoreCase(orderName)) {
                                    price = mi.getPrize();
                                }
                            }
                            OrderItem orderItem = new OrderItem(id, orderName, orderQuantity, remark, price);
                            System.out.println("Before adding into order Items:" + this.orderItems.size());
                            this.orderItems.add(orderItem);
                            System.out.println("After adding into order Items:" + this.orderItems.size());
                        } else {
                            System.out.println("Not enough Quantity");
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    public void ordering() {
        try {
            double allTotalPrice = 0;

            int id = this.orders.size() + 1;
            //  this.makeAnOrder();
            int tableNo = this.input.readIntInput("Enter table number to order");
            if (tableNo < 1) {
                System.out.println("try again!!");
                return;
            }
                Table table = this.searchTableByID(tableNo);
                if (table != null) {
                    this.makeAnOrder();

                    System.out.println("Starting order Item price calculation:" + this.orderItems.size());
                    for (OrderItem item: this.orderItems) {

                        allTotalPrice += item.totalPrice();
                       // System.out.println("Thank you for spanding " + allTotalPrice + "at our restaurant.");
                    }
                }
                Order order=new Order(id,orderItems.toArray(new OrderItem[0]),tableNo,allTotalPrice);
                this.orders.add(order);
            System.out.println("Thank you for spanding " + allTotalPrice + "at our restaurant.");


        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    public void dailySaleReport() {
        double TotalPrice = 0;
        for (Order sale : orders) {
            TotalPrice += sale.getTotalOrderPrize();
            System.out.println("Total Sale is"+TotalPrice);
        }

        DailyReport dailyReport=new DailyReport(TotalPrice,LocalDate.now().toString());
        this.dailyReports.add(dailyReport);
        dailyReport.describeDailyReport();
    }


    }
























