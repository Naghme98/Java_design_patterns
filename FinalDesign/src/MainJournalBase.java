package src;

import Adapter.*;
import decorator.*;
import Observer.*;
import State.*;
import Strategy.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainJournalBase {

private static Journal[] journals = {null , null , null};
private static ArrayList<User> users = new ArrayList<>();

  public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      String [] inputValue = scanner.nextLine().split(" ");
      while(!inputValue[0].equals("Q")){
          System.out.println("Command: "+inputValue[0]+"\n");
          switch(inputValue[0]){
            case "/printInfo":
            for(Journal x: journals){
                if(x != null)
                    x.printInfo();
            }
            break;
//------------------------------------ADD AND REMOVE DECORATOR------------------------------------------------
            case "/addQ":
            for(Journal x: journals){
                if(x != null)
                    x.addQ();
            }
            break;

            case "/removeQ":
            for(Journal x: journals){
                if(x != null)
                    x.removeSign("decorator.QuestionMark");
                
            }
            break;

            case "/addStar":
            for(Journal x: journals){
                if(x != null)
                    x.addS();
            }
            break;

            case "/removeStar":
            for(Journal x: journals){
                if(x != null)
                    x.removeSign("decorator.StarMark");;
            }
            break;


//------------------------------------CREATEMODEL------------------------------------------------        

            case "/createModel":
            
            try {
                if(inputValue[1].equals("sport")) {
                    journals[0] = Sport.getInstance();
                    journals[0].printInfo();
                }else if(inputValue[1].equals("political")) {
                    journals[1] = Political.getInstance();
                    journals[1].printInfo();

                }else if(inputValue[1].equals("economical")){
                    journals[2] = Economical.getInstance();
                    journals[2].printInfo();
                }
            }catch (NullPointerException np){
                System.out.println("Input was entered wrong.");
            }
            break;


//------------------------------------SUBSCRIBE------------------------------------------------


            case "/subscribe":
            int userNo = Integer.parseInt(inputValue[2])-1;
                try{
                    Journal journal = type(inputValue[1]);
                    if(journal != null && userNo<users.size())
                    journal.attachUser(users.get(userNo));
                    else{
                        if(journal==null) System.out.println("There is no such a journal");
                        if(userNo>=users.size()) System.out.println("There is no such a user");
                    }    
    
                }catch (NullPointerException np){
                    System.out.println("The Object doesn't find.");
                }catch (IndexOutOfBoundsException io){
                    System.out.println("Input was entered wrong.");
                }
            break;


//------------------------------------UnSUBSCRIBE------------------------------------------------


            case "/unSubscribe":
            int userNo2 = Integer.parseInt(inputValue[2])-1;
                try{
                    Journal journal = type(inputValue[1]);
                    if(journal != null && userNo2<users.size())
                        journal.detachUser(users.get(userNo2));
                    else{
                        if(journals[0]==null) System.out.println("There is no such a journal");
                        if(userNo2>=users.size()) System.out.println("There is no such a user");
                    }    
    
                }catch (NullPointerException np){
                    System.out.println("The Object doesn't find.");
                }catch (IndexOutOfBoundsException io){
                    System.out.println("Input was entered wrong.");
                }
            break;



//------------------------------------CREATE CHARACTER------------------------------------------------     


            case "/createCharacter":
            //  command Model :  /createCharacter "firstName" "lastName" "year/month/date" "studentNumber" "home-address-12" "male/femail"
            int id = users.size();
            User u = new User(inputValue[1], inputValue[2],inputValue[3], inputValue[4], inputValue[5],inputValue[6], (int)(id+1));
            users.add(u);
            System.out.println(users.get(users.size()-1).toString());
            break;



//------------------------------------GET ALL SUBSCRIBERS----------------------------------------------------

            case "/showSubscribers":
            try{
                Journal journal = type(inputValue[1]);
                if(journal != null)
                    journal.showSubscribers();

            }catch (NullPointerException np){
                System.out.println("The Object doesn't find.");
            }catch (IndexOutOfBoundsException io){
                System.out.println("Input was entered wrong.");
            }
            break;
//------------------------------------GET ALL USERS----------------------------------------------------

            case "/showUsers":
               for(User us : users){
                  System.out.println(us.toString());
               }
            break;
//------------------------------------STATE METHODS----------------------------------------------------


            
            case "/getEditingProgress":
            try{
                Journal journal = type(inputValue[1]);
                if(journal.getProcess().getName().equals("Editing")){
                    System.out.println(journal.getProcess().GetEditingProgress());
                }
                else System.out.println("Wrong State");

            }catch (NullPointerException np){
                System.out.println("The Object doesn't find.");
            }catch (IndexOutOfBoundsException io){
                System.out.println("Input was entered wrong.");
            }
            break;

            case "/startPrinting":
            try{
                Journal journal = type(inputValue[1]);
                if(journal.getProcess().getName().equals("Editing")){
                    journal.ChangeProcess();
                    System.out.println("State has changed to Printing");
                }
                else System.out.println("Wrong State");

            }catch (NullPointerException np){
                System.out.println("The Object doesn't find.");
            }catch (IndexOutOfBoundsException io){
                System.out.println("Input was entered wrong.");
            }
            break;

            case "/getPrintingProgress":
            try {
                Journal journal = type(inputValue[1]);
                if(journal.getProcess().getName().equals("Printing")){
                    System.out.println(journal.getProcess().GetEditingProgress());
                }
                else System.out.println("Wrong State");
            }catch (NullPointerException np){
                System.out.println("The Object doesn't find.");
            }catch (IndexOutOfBoundsException io){
                System.out.println("Input was entered wrong.");
            }
            break;

            case "/startPublishing":
            try {
                Journal journal = type(inputValue[1]);
                if(journal.getProcess().getName().equals("Printing")){
                    journal.ChangeProcess();
                    System.out.println("State has changed to Publishing");
                }
                else System.out.println("Wrong State");
            }catch (NullPointerException np){
                System.out.println("The Object doesn't find.");
            }catch (IndexOutOfBoundsException io){
                System.out.println("Input was entered wrong.");
            }
            break;


            case "/publish":
            try {
                Journal journal = type(inputValue[1]);
                    if(journal.getProcess().getName().equals("Publishing")){
                        journal.getProcess().publish(journal,inputValue[2],users);
                    }
                    else System.out.println("Wrong State");
                }catch (NullPointerException np){
                    System.out.println("The Object doesn't find.");
                }catch (IndexOutOfBoundsException io){
                    System.out.println("Input was entered wrong.");
                }
            break;


            case "/setPublishingMethod":
            HowToPublish h = null;
            if(inputValue[2].equals("courier"))
                h = new Courier();
            else if (inputValue[2].equals("online"))
                h = new Online();    
                switch(inputValue[1]){
                    case "sport":
                    journals[0].setHowToPublish(h);
                    break;
                    case "political":
                    journals[1].setHowToPublish(h);
                    break;
                    case "economical":
                    journals[2].setHowToPublish(h);
                    break;
                }
            break;

          
      }
      System.out.println("\n-----------------------------------------------");
      inputValue = scanner.nextLine().split(" ");
    }  
  
}
public static Journal type(String inputValue) {

    switch (inputValue) {
        case "sport":
            if (journals[0] != null)
                return journals[0];
            break;
        case "political":
            if (journals[1] != null)
                return journals[1];
            break;
        case "economical":
            if (journals[2] != null)
                return journals[2];
            break;
    }
    return null;
}

}