public class Table {
    public int Id;
    public int size;
    public Table(int Id,int size){
        this.Id=Id;
        this.size=size;
    }
    public void describeTable() {
        System.out.println("Id:" + this.Id);
        System.out.println("Sie:" + this.size);
    }

    public int getId() {
        return Id;
    }
}
