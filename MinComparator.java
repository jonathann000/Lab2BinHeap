import java.util.Comparator;


public class MinComparator<E> implements Comparator<Bid> {


    @Override
    public int compare(Bid b1, Bid b2) {
        int p1 = b1.price;
        int p2 = b2.price;

        return Integer.compare(p1, p2);

    }

}