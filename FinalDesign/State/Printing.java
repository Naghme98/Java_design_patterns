package State;
import java.util.Random;

public class Printing extends Process {
    private String name = "Printing";

    @Override
    public Process ChangeProcessState(){
        return new Publishing();
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
