public class MenuItem {
    private int id;
    private String menuName;
    private double prize;
    public MenuItem(int id, String menuName,double prize){
        this.id=id;
        this.menuName=menuName;
        this.prize=prize;
    }

    public void describeMenuItem() {
        System.out.println("Id:" + this.id);
        System.out.println("Name:" + this.menuName);
        System.out.println("Prize:" + this.prize);

    }

}
