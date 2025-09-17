public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private int shopId;
    private String category;//phan loai san pham
    private String description;
    private String image;

    //Contructor
    public Product(int id, String name, int price, int stock , int shopId, String category, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.shopId = shopId;
        this.category = category;
        this.description = description;
        this.image = image;
    }
// Getter & Setter
    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public int getPrice() { 
        return price; 
    }

    public void setPrice(int price) { 
        this.price = price; 
    }

    public int getStock() { 
        return stock; 
    }
    public void setStock(int stock) {
         this.stock = stock; 
    }

    public int getShopId() { 
        return shopId; 
    }

    public void setShopId(int shopId) { 
        this.shopId = shopId; 
    }

    public String getCategory() {
         return category; 
    }
    public void setCategory(String category) { 
        this.category = category;
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description;
    }

    public String getImage() { 
        return image;
    }
    public void setImage(String image) { 
        this.image = image;
    }
    //update()
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
        return "Product[ ID: "  + id + ",Name: " + name + ",Price: " + price +",Stock: " + stock + ",Categpry: " + category + ",Description: " 
        + description + ",Image: " + image;
    }
}
