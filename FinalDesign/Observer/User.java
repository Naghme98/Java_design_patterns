package Observer;


public class User {
    private String status;
    public int userID;
    private PersonalInformation personalInfo;

    public User(String firstName, String lastName, String birthdate, String studentNumber,
    String homeAddress, String gender, int userID){
        personalInfo = new PersonalInformation(firstName, lastName, birthdate, studentNumber, homeAddress, gender);
        this.userID = userID;
    }
    public void update(String status){
        this.status = status;
    }
    public PersonalInformation getPersonalInformation(){
        return personalInfo;
    }
    @Override
    public String toString(){
        return "Character "+userID+" has been created.\n"+"\nFirstName and LastName: "+personalInfo.getFirstName()+" "+personalInfo.getLastName()
        +"\nstudent number: "+personalInfo.getStudentNumber()+"\nhome address: "+personalInfo.getHomeAddress()
        +"\nbithdate: "+personalInfo.getBirthdate()+"\ngender: "+personalInfo.getgGender()+"\nStatus: "+status;
    }

}
