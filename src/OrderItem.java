import java.util.ArrayList;

public class OrderItem {
    private int id;
    private String menuItem;
    private double quantity;
    private double price;
    private String remark;
    private ArrayList<MenuItem> menuItems;
    public OrderItem(int id, String menuItem, double quantity, String remark, double price) {
        this.id = id;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.remark = remark;
        this.price = price;
    }
    public void describeOrderItem() {
        System.out.println("Order Id:" + this.id);
        System.out.println("Name:" + this.menuItem);
        System.out.println("Quantity:" + this.quantity);
        System.out.println("Remark:" + this.remark);
        this.menuItems = new ArrayList<>();
    }
    public double totalPrice(){

        return this.price * this.quantity;
    }
}
