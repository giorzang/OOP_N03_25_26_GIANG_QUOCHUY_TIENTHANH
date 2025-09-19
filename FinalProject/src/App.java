public class App {
    public static void main(String[] args) throws Exception {
        //User
        System.out.println("\nTest GetUser:");
        TestUser.testGet();

        System.out.println("\nTest SeUser:");
        TestUser.testSet();

        System.out.println("\nTest Login User:");
        TestUser.testLogin();

        System.out.println("\nTest Update User:");
        TestUser.testUpdate();
        
        // //Product
        // System.out.println("\nTest GetProduct:");
        // TestProduct.testGetProduct();
        // System.out.println("\nTest Set Product:");
        // TestProduct.testSetProduct();
    }
}
