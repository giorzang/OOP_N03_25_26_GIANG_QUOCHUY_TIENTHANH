public class TestProduct {
    public static void testGetProduct () {
        Product p = new Product(1, "jacket", 1000000, 0, "Black and Red", "Sold out");
        System.out.println("id: " + p.getId());
        System.out.println("name: " + p.getName());
        System.out.println("price: " + p.getPrice());
        System.out.println("stock: " + p.getStock());
        System.out.println("description:" + p.getDescription());
        System.out.println("image: " + p.getImage());
    }
   public static void testSetProduct() {
    Product p = new Product(2, "coat", 1000000, 10000, "Black", "in stock");

    p.setId(3);
    p.setName("Pants");
    p.setPrice(10000000);
    p.setStock(109);
    p.setDescription("Blue and Pink");
    p.setImage("in stock");

       System.out.println("id: " + p.getId());
        System.out.println("name: " + p.getName());
        System.out.println("price: " + p.getPrice());
        System.out.println("stock: " + p.getStock());
        System.out.println("description: " + p.getDescription());
        System.out.println("image: " + p.getImage());
   }
   public static void testUpdate() {
       Product p = new Product();
        service.updateProduct(1, "Ao thun co tron", "Ao thun mau trang", 120, 15, "ao1_new.jpg");
   }
}
=======
    public class TestProduct {
        public static void testGetProduct () {
            Product p = new Product(1, "jacket", 1000000, 0, 1, "Man", "Black and Red", "Sold out");
            System.out.println("id: " + p.getId());
            System.out.println("name: " + p.getName());
            System.out.println("price: " + p.getPrice());
            System.out.println("stock: " + p.getStock());
            System.out.println("shop id: " + p.getShopId());
            System.out.println("description: " + p.getDescription());
            System.out.println("image: " + p.getImage());
        }
    public static void testSetProduct() {
        Product p = new Product(2, "coat", 1000000, 10000, 1, "Man", "Black", "in stock");

        p.setId(3);
        p.setName("Pants");
        p.setPrice(10000000);
        p.setStock(109);
        p.setCategory("men");
        p.setDescription("Blue and Pink");

        System.out.println("id: " + p.getId());
            System.out.println("name: " + p.getName());
            System.out.println("price: " + p.getPrice());
            System.out.println("stock: " + p.getStock());
            System.out.println("shop id: " + p.getShopId());
            System.out.println("description: " + p.getDescription());
            System.out.println("image: " + p.getImage());
    }
    }
>>>>>>> 1b4844c36bb4de9a96c2d311e2d990c146fe8c49
