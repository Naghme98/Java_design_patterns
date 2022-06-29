package Observer;
import src.Journal;
import decorator.TextView;

import java.util.Random;


public class Economical extends Journal {
    //Variables ========================================================================================================
    private static Economical economical;
    //==================================================================================================================

    //Private Constructor ==============================================================================================
    private Economical(){
        register_number = new Random().nextInt(100000);
        name = "Economical";
        editor = "Hossein Poor";
        reportForMain = new TextView(saleNumber, numberOfCustomers, printingCost, name, dateStablished, register_number, editor);
   
    }
    //==================================================================================================================

    public static synchronized Economical getInstance(){
        if (economical == null)
            economical = new Economical();
        return economical;
    }
    

}
