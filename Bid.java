/**
 * Authors: Jonathan Naumanen, Alexander Stenström, Adam Williams.
 */
public class Bid {
    final public String name;
    final public int price;

    /**
     * @param name Säljaren/Köparens namn angett som en string
     * @param price Budet angett som ett intvärde
     */

    public Bid(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int hashCode() {
        return 1 + 23 * price + 31 * name.hashCode();
    }
    /**
     * Metod som jämför bids med varandra
     * O(1)
     * @return bid
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Bid bid)) return false;
        return bid.price == this.price;
    }
    /**
     * toString metod som returnerar budet i form av en string
     * O(1)
     * @return string
     */

    public String toString() {
        return (this.name + " " + price);
    }
}

