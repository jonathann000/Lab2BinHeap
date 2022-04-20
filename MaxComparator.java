import java.util.Comparator;
import java.util.PriorityQueue;

class MaxComparator<E extends Comparable> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o2.compareTo(o1);
    }

}
