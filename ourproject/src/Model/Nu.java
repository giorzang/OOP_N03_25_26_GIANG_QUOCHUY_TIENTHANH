package Model;

public class Nu {
    //thuoc tinh
    public String Name;
    public String Major;
    public String Born;
    public String DateofBirth;

    //phuong thuoc
    public void print(String name, String major, String born, String dob){
        Name = name;
        Major = major;
        Born = born;
        DateofBirth = dob;

        System.out.println("Full name : " + Name + "Major: " + Major + " Place of Birth : " + born + "Date of Birth " + dob);
    }
}

}
