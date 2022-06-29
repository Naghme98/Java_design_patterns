package Strategy;

public class Courier extends HowToPublish {

    @Override
    public void sending(int id) {
        System.out.println("Courier: Character "+id+" got the notif");
    }
   
}
