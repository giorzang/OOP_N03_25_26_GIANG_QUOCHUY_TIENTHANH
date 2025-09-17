public class NameNumber{
    private String lastName;
    private String telNumber;
    public NameNumber(){};
    public NameNumber(String lastname, String telnumber) {
        lastName = lastname;
        telNumber = telnumber;
    }
    public String getLastName(){
        return lastName;
    }
    public String getTelNumber(){
        return telNumber;
    }
}