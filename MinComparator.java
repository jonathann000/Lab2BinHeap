import java.util.Comparator;


public class MinComparator<E> implements Comparator<E> {


    @Override
    public int compare(E e1, E e2) {
        if (!(e1 instanceof Bid && e2 instanceof Bid)) throw new RuntimeException("Not bid stupid");
        Bid b1 = (Bid) e1;
        Bid b2 = (Bid) e2;
        int p1 = b1.price;
        int p2 = b2.price;
        return Integer.compare(p1, p2);
    }
}