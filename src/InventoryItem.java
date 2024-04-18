public class InventoryItem {
    private int id;
    private String name;
    private double count;

    public InventoryItem(int id, String name,double count){
        this.id=id;
        this.name=name;
        this.count=count;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(double count) {

        this.count = count;
    }

    public void describeInventoryItem() {
        System.out.println("Inventory Id:" + this.id);
        System.out.println("Name:" + this.name);
        System.out.println("Count:" + this.count);

    }
}

