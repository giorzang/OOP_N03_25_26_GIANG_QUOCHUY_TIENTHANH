public class App {
    public static void main(String[] args) {
        Facilities f = new Facilities();

        // gan gia tri
        f.chisoGiaoVien = "Tot";
        f.soLuongPhongHoc = 20;
        f.soLuongLab = 5;
        f.chatLuongPhongHoc = "Kha";
        f.chatLuongGiaoVien = "Tot";
        f.heThongQuanLy = "Hien dai";
        f.chiSoTrangThietBiTheThao = "Day du";

        // in ra
        f.print();
    }
}
