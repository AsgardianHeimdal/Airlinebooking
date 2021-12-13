import java.util.ArrayList;

public class TicketBook {
    ArrayList<BookingDetails> book = new ArrayList<>();


    //book ticket:
    public boolean booktick(String from,String to,String datetime,Long mobno){
       boolean booked =  book.add(new BookingDetails(from,to,datetime,mobno));
        if(booked){
            return true;
        }
        return false;
    }
    //cancel ticket:
    public boolean canceltick(Long revnum){
   int ind = exist(revnum);
   if(ind >= 0){
       book.remove(ind);
       return true;
   }
   return false;
    }
    //exist:
    public int exist(Long revnum){
        for (int i = 0;i < book.size();i++){
            if (revnum == book.get(i).getRevnum()){
                return i;
            }
        }
        return -1;
    }

    public int exist1(Long mobno){
        for (int i = 0; i < book.size();i++){
            if(mobno == book.get(i).getMobno()){
                return i;
            }
        }
        return -1;
    }

}
