package State;
import java.util.Random;

public class Editing extends Process {
    private String name = "Editing";

    @Override
    public Process ChangeProcessState(){
        return new Printing();
    }
    @Override
    public int GetEditingProgress(){
        Random random = new Random();
        int progress = random.nextInt(101); // between 0 to 100
        return progress;
    }
    @Override
    public String getName() {
        return name;
    }

}
