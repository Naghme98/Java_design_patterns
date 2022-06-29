package Observer;


public class PersonalInformation{
    private String firstName;
    private String lastName;
    private String birthdate;
    private String studentNumber;
    private String homeAddress;
    private String gender;
    public PersonalInformation(String firstName, String lastName, String birthdate, String studentNumber,
     String homeAddress, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.studentNumber = studentNumber;
        this.homeAddress = homeAddress;
        this.gender = gender;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getStudentNumber(){
        return studentNumber;
    }
    public String getHomeAddress(){
        return homeAddress;
    }
    public String getBirthdate(){
        return birthdate;
    }
    public String getgGender(){
        return gender;
    }


}