import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxComparator<E> implements Comparator<Bid> {

    @Override
    public int compare(Bid o1, Bid o2) {

        int p1 = o1.price;
        int p2 = o2.price;

        return Integer.compare(p2, p1);
    }

}
