package sg.edu.nus.iss.ssf_13t.model;

import jakarta.validation.constraints.Min;

public class Item {
    private String id;
    private String name;
    private int sold;
    @Min(value = 1, message="This item is sold out.")
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

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }


}
