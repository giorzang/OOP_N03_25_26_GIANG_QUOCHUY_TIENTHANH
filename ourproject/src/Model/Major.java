public class Major {
    public String maTruong;
    public String maNghanh;
    public String tenNghanh;
    public String diemChuan;

    // phuong thuc
    public void print(String matruong, String manghanh, String tennghanh, String diemchuan) {
        maTruong = matruong;
        maNghanh = manghanh;
        tenNghanh = tennghanh;
        diemChuan = diemchuan;

        System.out.println("Ma truong: " + maTruong);
        System.out.println("Ma nghanh: " + maNghanh);
        System.out.println("Ten nghanh: " + tenNghanh);
        System.out.println("Diem chuan: " + diemChuan);
    }
}
