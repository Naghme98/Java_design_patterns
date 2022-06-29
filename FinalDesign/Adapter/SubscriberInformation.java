package Adapter;

public class SubscriberInformation {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String homeAddress;
    public int userID;
    private String status;

    public void update(String status){
        this.status = status;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setStudentNumber(String studentNumber){
        this.studentNumber = studentNumber;
    }
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public void setStatus(String status){
        this.status = status;
    }
    @Override
    public String toString(){
        return "Subsciber ID: "+userID +"\nFirstName and LastName: "+firstName+" "+lastName
        +"\nstudent number: "+studentNumber+"\nhome address: "+homeAddress + "\nstatus: "+status;
    }

}