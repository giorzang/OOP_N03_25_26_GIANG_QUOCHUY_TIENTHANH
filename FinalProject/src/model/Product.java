public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private String category;
    private String description;
    private String image;

    public Product(int id, String name, int price, int stock, String category, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void upDate(String name, int price, int stock, String category, String description, String image) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.description = description;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price +
               ", stock=" + stock + ", category='" + category + "', description='" +
               description + "', image='" + image + "'}";
    }
}
