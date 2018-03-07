public class Item {
    private String name;
    private int categoty_id;
    private int seller_id;
    private float rating;
    private float price;

    public Item(String name, int categoty_id, int seller_id, float rating, float price) {
        this.name = name;
        this.categoty_id = categoty_id;
        this.seller_id = seller_id;
        this.rating = rating;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcategoty_id() {
        return categoty_id;
    }

    public void setcategoty_id(int categoty_id) {
        this.categoty_id = categoty_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

