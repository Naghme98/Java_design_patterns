package Observer;
import src.Journal;
import decorator.TextView;

import java.util.Random;


public class Political extends Journal {
    //Variables ========================================================================================================
    private static Political political;
    //==================================================================================================================

    //Private Constructor ==============================================================================================
     private Political(){
        register_number = new Random().nextInt(100000);
        name = "Political";
        editor = "Dr.Rasool Zadegan";
        reportForMain = new TextView(saleNumber, numberOfCustomers, printingCost, name, dateStablished, register_number, editor);
   
     }
    //==================================================================================================================

    public static synchronized Political getInstance(){
        if (political == null)
            political = new Political();
        return political;
    }

}
