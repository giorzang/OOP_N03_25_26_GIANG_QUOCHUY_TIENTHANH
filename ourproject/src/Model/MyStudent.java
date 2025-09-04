package Model;
public class MyStudent {
    private String nameSv;
    private String IDSV;
    private String myClass;
    private String myDepartment;

    public MyStudent() {};

    public MyStudent(String nameSv, String IDSV, String myClass, String myDepartment) {
        this.nameSv = nameSv;
        this.IDSV = IDSV;
        this.myClass = myClass;
        this.myDepartment = myDepartment;
    }
//getter va setter
    public String getName() {
        return nameSv;
    }

    public String getID() {
        return IDSV;
    }

    public String getMyClass() {
        return myClass;
    }

    public String getMyDepartment() {
        return myDepartment;
    }

    public void setName(String nameSv) {
        this.nameSv = nameSv;
    }

    public void setID(String IDSV) {
        this.IDSV = IDSV;
    }

    public void setMyClass(String myClass) {
        this.myClass = myClass;
    }
    public void setMyDepartment(String myDepartment) {
        this.myDepartment = myDepartment;
    }
}