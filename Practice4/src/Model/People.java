public class People {
    private String FullName;
    private String DateOfBirth;
    private String Identity;

    public People() {};
    public  People(String FullName, String DateOfBirth, String Identity) {
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Identity = Identity;
    }

    public String getInformation() {
        return FullName + ", " + DateOfBirth + ", " + Identity;
    }
    public void setInformation(String FullName, String DateOfBirth, String Identity) {
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Identity = Identity;
    }
}
