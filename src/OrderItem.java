public class OrderItem {
    private int id;
    private String menuItem;
    private double quantity;
    private String remark;

    public OrderItem(int id, String menuItem, double quantity, String remark) {
        this.id = id;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.remark = remark;
    }
    public void describeOrderItem() {
        System.out.println("Id:" + this.id);
        System.out.println("Name:" + this.menuItem);
        System.out.println("Quantity:" + this.quantity);
        System.out.println("Remark:" + this.remark);

    }
}
