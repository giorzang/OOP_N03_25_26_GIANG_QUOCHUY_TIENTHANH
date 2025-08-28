package  Model;

public class Universities {

    public String maTruong;
    public String tenTruong;
    public String diaDiem;

    // phuong thuc
    public void print(String maTruong, String tenTruong, String diaDiem) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaDiem = diaDiem;

        System.out.println("Ma truong: " + maTruong);
        System.out.println("Ten truong: " + tenTruong);
        System.out.println("Dia diem: " + diaDiem);
    }
}
