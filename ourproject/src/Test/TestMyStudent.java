import Model.MyStudent;

public class TestMyStudent {
    public static void main(String[] args) {
        // Tạo đối tượng bằng constructor mặc định
        MyStudent st1 = new MyStudent();
        st1.setName("Nguyen Van A");
        st1.setID("SV001");
        st1.setMyClass("CNTT1");
        st1.setMyDepartment("Khoa CNTT");

        // Tạo đối tượng bằng constructor có tham số
        MyStudent st2 = new MyStudent("Tran Thi B", "SV002", "CNTT2", "Khoa CNTT");

        // In ra thông tin
        System.out.println("=== Student 1 ===");
        System.out.println("Name: " + st1.getName());
        System.out.println("ID: " + st1.getID());
        System.out.println("Class: " + st1.getMyClass());
        System.out.println("Department: " + st1.getMyDepartment());

        System.out.println("\n=== Student 2 ===");
        System.out.println("Name: " + st2.getName());
        System.out.println("ID: " + st2.getID());
        System.out.println("Class: " + st2.getMyClass());
        System.out.println("Department: " + st2.getMyDepartment());
    }
}
