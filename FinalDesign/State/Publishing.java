package State;

import java.util.ArrayList;

import Observer.User;
import src.Journal;

public class Publishing extends Process {
    private String name = "Publishing";

    @Override
    public Process ChangeProcessState() {
        return this;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void publish(Journal journal, String status, ArrayList<User> users){
        journal.notifying(status, users);

    }
}

