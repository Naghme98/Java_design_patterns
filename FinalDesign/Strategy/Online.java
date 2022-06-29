package Strategy;

public class Online extends HowToPublish {

    @Override
    public void sending(int id) {
        System.out.println("Online: We sent notif to Character "+id);
    }

}
