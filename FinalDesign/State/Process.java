package State;

import java.util.ArrayList;

import Observer.User;
import src.Journal;

public abstract class Process {
    //Abstract Method ==================================================================================================
    public abstract String getName();
    public abstract Process ChangeProcessState();
    //==================================================================================================================
    public void publish(Journal journal, String status, ArrayList<User> users){
        System.out.println("Wrong! only in publishing state");
    }
    public int GetEditingProgress(){
        System.out.println("There is no Editing for Publishing state");
        return -1;
    }
}
