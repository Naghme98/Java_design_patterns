package Observer;
import src.Journal;
import java.util.Random;
import decorator.TextView;

public class Sport extends Journal {
    //Variables ========================================================================================================
    private static Sport sport;

    //==================================================================================================================

    //Private Constructor ==============================================================================================
    private Sport(){
        register_number = new Random().nextInt(100000);
        name = "Sport";
        editor = "Sabeghi";
        reportForMain = new TextView(saleNumber, numberOfCustomers, printingCost, name, dateStablished, register_number, editor);
   
    }
    //==================================================================================================================

    public static synchronized Sport getInstance(){
        if (sport == null)
            sport = new Sport();
        return sport;
    }

}
