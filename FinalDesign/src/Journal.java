package src;

import Observer.PersonalInformation;
import Observer.User;
import State.Process;
import State.Editing;
import Strategy.Courier;
import Strategy.HowToPublish;
import Adapter.Encryption;
import Adapter.SubscriberInformation;
import Adapter.Target;

import java.util.ArrayList;

import decorator.*;
import decorator.Report;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public abstract class Journal {
    //Private Pointers =================================================================================================
    private Process process = new Editing();
    private HowToPublish howToPublish = new Courier();
    // ** isnt it better for us to remove it from here? ***
    private ArrayList<User> users = new ArrayList<User>();
    // ***
    private ArrayList<SubscriberInformation> subscribers = new ArrayList<>();
    protected Report reportForMain ;
    protected int register_number;
    protected String editor;
    protected String name ;
    protected LocalDateTime dateStablished ;
    protected int saleNumber = 0;
    protected int numberOfCustomers = 0;
    protected float printingCost = 0;
    private Target adapterTarget = new Encryption();
    //==================================================================================================================

    //Constructors ===================================
    public Journal(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        dateStablished = LocalDateTime.now();  
     }
    //==================================================================================================================


    //Observer Methods =================================
    public void attachUser(User user){ 
        for (SubscriberInformation s : subscribers){
            if (user.userID == s.userID){
                System.out.println("You have been subscribed to this journal before");
                return;
            }
        }
       
        SubscriberInformation s = adapterTarget.createSubsciber(user.getPersonalInformation(), user.userID);
        subscribers.add(s);
        System.out.println(subscribers.get(subscribers.size()-1).toString());
     }

    public void detachUser(User user){ 
        for (SubscriberInformation s : subscribers){
            if (user.userID == s.userID)
                subscribers.remove(s);
                System.out.println("User "+user.userID+" sucessfull detached");
                return;
        }
        System.out.println("User "+user.userID+" wasnt a subscriber here");
    }

    public void showSubscribers(){
        for(SubscriberInformation s : subscribers){
            System.out.println(s.toString());
            System.out.println("     ==================     ");
        }
    }

    public void notifying(String status, ArrayList<User> users){
        try{
            for( SubscriberInformation i : subscribers){
                users.get(i.userID-1).update(status);
                i.update(status);
                howToPublish.sending(i.userID);
            }
            System.out.println("End the notifying");
        }catch (NullPointerException np){
            System.out.println("No User registered.");
        }
    }
    //==================================================================================================================

    //State Methods =======================================
    public void ChangeProcess(){
        process = process.ChangeProcessState();
    }
    public Process getProcess(){
        return process;
    }
    //==================================================================================================================

    //Strategy Method =======================================
    public void setHowToPublish(HowToPublish howToPublish){
        System.out.println(name+"’s publishing method has been set to "+howToPublish.getClass().getName().split("\\.")[1]);
        this.howToPublish = howToPublish;
    }
    //==================================================================================================================

    //Setters =================================
    public void setEditorName(String name){
        this.editor = name;
    }
    //==================================================================================================================

    //Decorator =================================

    public void printInfo(){
        System.out.println(reportForMain.showText());
    }
    public void addQ(){
        reportForMain = new QuestionMark(reportForMain);
    }
    public void addS(){
        reportForMain = new StarMark(reportForMain);
    }
    public void removeSign(String type){
        reportForMain = reportForMain.removeDecorate(type);
    }
    

}
