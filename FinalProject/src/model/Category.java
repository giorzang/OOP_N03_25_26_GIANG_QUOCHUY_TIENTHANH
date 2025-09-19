public class Category {
    private int id;
    private String description;
    private int productId;

    public Category(int id, String description, int productId) {
        this.id = id;
        this.description = description;
        this.productId = productId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public void update(String description, int productId) {
        this.description = description;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Category [id=" + id +
                ", description=" + description +
                ", productId=" + productId + "]";
    }
}
