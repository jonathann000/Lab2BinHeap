public class Bid {
    final public String name;
    final public int price;

    public Bid(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int hashCode() {
        return 1 + 23 * price + 31 * name.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Bid bid)) return false;
        return bid.price == this.price;
    }

    public String toString() {
        return (this.name + " " + price);
    }
}

