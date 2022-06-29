package Adapter;
import Observer.PersonalInformation;

public class Encryption extends Target{
    private SubscriberInformation sb;
    @Override
    public SubscriberInformation createSubsciber(PersonalInformation personalInfo,int userID){
        sb = new SubscriberInformation();
        sb.setFirstName(convertFirstName(personalInfo.getFirstName()));
        sb.setLastName(convertLastName(personalInfo.getLastName()));
        sb.setStudentNumber(convertStudentNumber(personalInfo.getStudentNumber()));
        sb.setHomeAddress(convertHomeAddress(personalInfo.getHomeAddress()));
        sb.setUserID(userID);
        return sb;
    }
    private String convertFirstName(String first){
        String result = "";
        for(int i =0 ; i<first.length(); i++){
            char x = (char) (first.charAt(i) - 'b');
            result += x;
        }
        return result;
    }
    private String convertLastName(String last){
        String result = "";
        for(int i =0 ; i<last.length(); i++){
            if(i%2 == 1){
                result += "-";
            }
            else {
                result += last.charAt(i);
            }
        }
        return result;
    }
    private String convertStudentNumber(String student){
        String result = "";
        for(int i =0 ; i<student.length(); i++){
            if(i%2 == 0){
                result += Integer.parseInt(String.valueOf(student.charAt(i)))*2;  
            }
        }
        return result;
    }
    private String convertHomeAddress(String address){
        String result = "";
        String [] addressParts = address.split("-");
        for(int i =addressParts.length-1; i>=0 ; i--){
            result+= addressParts[i] +" * ";
        }
        return result;
    }
}