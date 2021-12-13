import java.util.Locale;

public class PriceEnquiry {
    public double price(String from,String to){
        String fromto = from + to;
        switch (fromto.toLowerCase()){
            case "chennaimadurai":
                return 5000.00;
            case "chennaitrichy":
                return 4000.00;
            case "chennaihydrabad":
                return 8000.00;
            case "chennaidelhi":
                return 10000.00;
            case "chennaipunjab":
                return 9000.00;
        }
        return 0;
    }
}
