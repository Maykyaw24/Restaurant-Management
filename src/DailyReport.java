public class DailyReport {
    private double totalPrice;
    private String date;


    public DailyReport(double totalPrice, String date){
        this.totalPrice=totalPrice;
        this.date=date;
    }
    public void describeDailyReport(){
        System.out.println("Total sale price for day("+date+") is "+totalPrice);
    }
}
