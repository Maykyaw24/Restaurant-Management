public class Order {
    private int id;
    private OrderItem[]orderItems;
    private int tableNumber;
    private double totalOrderPrize;

    public Order(int id, OrderItem[] orderItems, int tableNumber, double totalOrderPrize) {
        this.id = id;
        this.orderItems = orderItems;
        this.tableNumber = tableNumber;
        this.totalOrderPrize = totalOrderPrize;
    }
}
