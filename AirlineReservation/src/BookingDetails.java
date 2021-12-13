public class BookingDetails {
    private String fromto;
    private String datetime;
    private long mobno;
    private long revnum;
    private boolean flag = true;
    private double price;
    private PriceEnquiry priceEnquiry = new PriceEnquiry();
    {
        revnum();
    }

    public BookingDetails(String from,String to,String datetime,Long mobno){
        this.fromto = (from + to).toLowerCase();
        this.datetime = datetime;
        this.mobno = mobno;
        this.price = priceEnquiry.price(from,to);
    }



    //reservation number:
    public void revnum(){
        long random = Math.round(Math.random()*1000000);
        if(flag){
            this.revnum = random;
            System.out.println(revnum);
            flag = false;
        }
        System.out.println("your reservation number is " + this.revnum);
    }



    //getter:
    public String getFromto() {
        return fromto;
    }

    public String getDatetime() {
        return datetime;
    }

    public long getMobno() {
        return mobno;
    }

    public double getPrice() {
        return price;
    }

    public long getRevnum() {
        return revnum;
    }
}
