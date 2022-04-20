public class Bid {
	final public String name;
	final public int bid;

	public Bid(String name, int bid) {
		this.name = name;
		this.bid = bid;
	}

	public int hashCode() {
		return 1 + 23*bid + 31*name.hashCode();
	}

	public boolean equals(Object obj){
		if (obj == null || !(obj instanceof Bid)) return false;

		Bid bid = (Bid) obj;

		// TODO: compare the objects
		if (bid.bid == this.bid) return true;
		else return false;
	}
	
	public String toString(){
		// TODO: return a description of the bid
		String mony = String.valueOf(this.bid);
		return (this.name + " " + mony + ",");
	}
}

