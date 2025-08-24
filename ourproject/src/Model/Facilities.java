public class Facilities {
    // cac thuoc tinh
    public String chisoGiaoVien;
    public int soLuongPhongHoc;
    public int soLuongLab;
    public String chatLuongPhongHoc;
    public String chatLuongGiaoVien;
    public String heThongQuanLy;
    public String chiSoTrangThietBiTheThao;

    // phuong thuc in thong tin
    public void print() {
        System.out.println("Chi so GV: " + chisoGiaoVien);
        System.out.println("So luong phong hoc: " + soLuongPhongHoc);
        System.out.println("So luong lab: " + soLuongLab);
        System.out.println("Chat luong phong hoc: " + chatLuongPhongHoc);
        System.out.println("Chat luong giao vien: " + chatLuongGiaoVien);
        System.out.println("He thong quan ly: " + heThongQuanLy);
        System.out.println("Chi so trang thiet bi the thao: " + chiSoTrangThietBiTheThao);
    }
}
