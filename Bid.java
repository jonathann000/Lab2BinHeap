public class Bid {
	final public String name;
	final public int price;

	public Bid(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int hashCode() {
		return 1 + 23*price + 31*name.hashCode();
	}

	public boolean equals(Object obj){
		if (obj == null || !(obj instanceof Bid)) return false;

		Bid bid = (Bid) obj;

		// TODO: compare the objects
		if (bid.price == this.price) return true;
		else return false;
	}
	
	public String toString(){
		return (this.name + " " + price);
	}
}

