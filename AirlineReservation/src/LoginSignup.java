import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class LoginSignup {
    private String name;
    private Long mobno;
    ArrayList<LoginSignup> custom = new ArrayList();
    LoginSignup current;
    private TicketBook ticketBook = new TicketBook();


    public LoginSignup(){

    }
    public LoginSignup(String name,Long mobno){
        this.name = name.toLowerCase();
        this.mobno = mobno;
    }
    //getters:
    public String getName() {
        return name;
    }

    public Long getMobno() {
        return mobno;
    }


    //login
    public boolean login(String username,long mobno){
        int ind  = checkuser(username,mobno);
        System.out.println(custom.get(0));
        System.out.println(ind);
        if(ind >= 0){
            current = custom.get(ind);
            System.out.println("welcome " + current.getName());
            return true;
        }
        System.out.println("user not exist please sign up!!");
        return false;
    }

    //login1:
    public boolean login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your username");
        String user  = sc.nextLine();
        System.out.println("enter your mob no!!");
        long mobno = sc.nextLong();
        sc.nextLine();
        boolean log = login(user,mobno);
        if(log) {
            return true;
        }
        signup();
        return false;
    }

    //signup:
    public boolean signup(String username,Long mobno){
        int ind= checkuser(username,mobno);
        if(ind < 0){
            custom.add(new LoginSignup(username,mobno));
            System.out.println(custom.get(0));
            return true;
        }
            System.out.println("user already exist please login!!");
        return false;
    }

    public boolean signup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your username");
        String user  = sc.nextLine();
        System.out.println("enter your mob no!!");
        long mobno = sc.nextLong();
        sc.nextLine();
        boolean log = signup(user,mobno);
        if(log) {
            login();
            return true;
        }
        signup();
        return false;
    }

    //check user:
    public int checkuser(String name,long mobno){
        for (int i = 0;i < custom.size();i++) {
            String getname = custom.get(i).getName();
            long getnum = custom.get(i).getMobno();
            if (name.toLowerCase().equals(getname) && mobno == getnum){
                return i;
            }
        }
        return -1;
    }

    //book ticket:
    public void booktick(String from,String to,String datetime,Long mobno){
        boolean flag1 = ticketBook.booktick(from,to,datetime,mobno);
        if(flag1){
            System.out.println("your ticket is booked sucessfully!!");
        }else {
            System.out.println("there is some error in booking please try later");
        }
    }
    //cancel ticket:
    public void canceltick(Long revnum){
boolean flag2 = ticketBook.canceltick(revnum);
if(flag2){
    System.out.println("you have sucessfully cancelled the ticket!!");
}else {
    System.out.println("there is no revnum which you entered!!!");
}
    }
    //check status:
    public void checkstatus(Long revnum){
int ind = ticketBook.exist(revnum);
if(ind >=0){
    BookingDetails tick = ticketBook.book.get(ind);
    System.out.println("from to "+ tick.getFromto());
    System.out.println("date time " + tick.getDatetime());
    System.out.println("mobile no " + tick.getMobno());
    System.out.println("price " + tick.getPrice());
}
    }

}
