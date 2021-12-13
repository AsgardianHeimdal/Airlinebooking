import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PriceEnquiry priceEnquiry = new PriceEnquiry();
    static LoginSignup loginSignup = new LoginSignup();
    static boolean flag = true;

    //main method:
    public static void main(String[] args) {
loginmenu();
while (flag) {
    menu();
    select();
}
    }

    public static void menu(){
        System.out.println("Enter your choice" + '\n' + "1.Check Price" + '\n' + "2.Book Ticket!!" + '\n' + "3.Cancel Ticket!!" + '\n' +"4.Check Status" + '\n' + "5.logout");
    }

    //select:
    public static void select(){
        int sel = sc.nextInt();
        sc.nextLine();

        switch (sel){
            case 1:
                System.out.println("enter destination!!");
                String des = sc.nextLine();
               double getprice =  priceEnquiry.price("chennai",des);
                System.out.println("your fare is " + getprice);
                break;

                //book tick:
            case 2:
                System.out.println("Enter destination");
                String des1 = sc.nextLine();
                System.out.println("enter date and time");
                String date1 = sc.nextLine();
                System.out.println("enter your mob no");
                long mob1 = sc.nextLong();
                sc.nextLine();
                loginSignup.booktick("chennai",des1,date1,mob1);
                break;


                //cancel tick:
            case 3:
                System.out.println("enter you reservation number");
                long rev2 = sc.nextLong();
                sc.nextLine();
                loginSignup.canceltick(rev2);
                break;

                //check status:
            case 4:
                System.out.println("enter your reservation number!!");
                long rev3  = sc.nextLong();
                loginSignup.checkstatus(rev3);
                break;
                //logout:
            case 5:
                loginmenu();
                break;
            case 6:
                System.out.println("bye!!");
                flag = false;
                break;
            default:
                System.out.println("enter the valid choice!!");

        }
    }

    //loginmenu:
    public static void loginmenu(){
        System.out.println("enter your choice!!" + '\n' + "1.Login" + '\n' + "2.Signup");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            //login:
            case 1:
                System.out.println("enter username to login");
                String user3 = sc.nextLine();
                System.out.println("enter your mob no");
                long mob3 = sc.nextLong();
                sc.nextLine();
                boolean flag3 = loginSignup.login(user3,mob3);
                if(flag3){
                    System.out.println("you have sucessfully logged in");
                }else {
                    loginSignup.signup();
                }
                break;
                //signup:
            case 2:
                System.out.println("enter the new username!!");
                String user4 = sc.nextLine();
                System.out.println("enter your mob no");
                long mob4 = sc.nextLong();
                sc.nextLine();
               boolean flag4 =  loginSignup.signup(user4,mob4);
               if(flag4){
                   System.out.println("you have signed up sucessfully please login");
               }
               loginSignup.login();
                break;
        }
    }
}
