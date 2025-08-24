public class Universities {
    public String maTruong;
    public String tenTruong;
    public String diaDiem;

    // phuong thuc
    public void print(String ma, String ten, String diadiem) {
        maTruong = ma;
        tenTruong = ten;
        diaDiem = diadiem;

        System.out.println("Ma truong: " + maTruong);
        System.out.println("Ten truong: " + tenTruong);
        System.out.println("Dia diem: " + diaDiem);
    }
}
