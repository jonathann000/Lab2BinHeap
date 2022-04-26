import java.util.Comparator;

public class MaxComparator<E> implements Comparator<E> {

    @Override
    public int compare(E e1, E e2) {
        if (!(e1 instanceof Bid b1 && e2 instanceof Bid b2)) throw new RuntimeException("Not bid stupid");
        int p1 = b1.price;
        int p2 = b2.price;
        return Integer.compare(p2, p1);
    }
}
