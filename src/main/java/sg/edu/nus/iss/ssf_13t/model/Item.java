package sg.edu.nus.iss.ssf_13t.model;

public class Item {
    private String id;
    private String name;
    private int sold;
    private int quantity;
    private String imageSrc;

    public Item(String id, String name, int sold, int quantity, String imageSrc) {
        this.id = id;
        this.name = name;
        this.sold = sold;
        this.quantity = quantity;
        this.imageSrc = imageSrc;
    }
    
    public Item() {
    }

    public void buy() {
        sold += 1;
        quantity -= 1;
    }

    public boolean isSoldOut() {
        return quantity <= 0;
    }

    public String getId() {return id;}

    public String getName() {return name;}
    
    public int getSold() {return sold;}
    public void setSold(int sold) {this.sold = sold;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getImageSrc() {return imageSrc;}
}
