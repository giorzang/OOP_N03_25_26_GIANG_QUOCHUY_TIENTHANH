public class testNNCollection{ 
    public static void testNN() {
        NNCollection collection = new NNCollection();

        // Them du lieu
        collection.insert(new NameNumber("Nguyen", "0123456789"));
        collection.insert(new NameNumber("Tran", "0987654321"));
        collection.insert(new NameNumber("Le", "0912345678"));

        // Tim kiem
        System.out.println("So dien thoai Nguyen: " + collection.findNumber("Nguyen"));
        System.out.println("So dien thoai Tran: " + collection.findNumber("Tran"));
        System.out.println("So dien thoai Le: " + collection.findNumber("Le"));
        System.out.println("So dien thoai Hoang: " + collection.findNumber("Hoang"));
    }
}