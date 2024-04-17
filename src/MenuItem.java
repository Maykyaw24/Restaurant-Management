public class MenuItem {
    private int id;
    private String menuName;
    private double prize;
    public MenuItem(int id, String menuName,double prize){
        this.id=id;
        this.menuName=menuName;
        this.prize=prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getMenuName() {
        return menuName;
    }

    public void describeMenuItem() {
        System.out.println("Id:" + this.id);
        System.out.println("Name:" + this.menuName);
        System.out.println("Prize:Kyat-" + this.prize);

    }

}
