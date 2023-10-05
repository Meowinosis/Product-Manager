package model;

public class Product {
    private String id;
    private String name;
    private int quantity;
    private int price;
    private String type;

    public Product() {
    }

    public Product(String id, String name, int quantity, int price, String type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

    public String getDataProduct() {
        return id + "," + name + "," + quantity + "," + price + "," + type;
    }
}
