import java.util.PriorityQueue;

public class MaxHeap<E extends Comparable> {
    public PriorityQueue<E> pQ;
    MaxHeap(int initialValue) {
        pQ = new PriorityQueue(initialValue, new MaxComparator());
    }

    public E findMax(){
        return pQ.peek();
    }

    public void deleteMax(){
        pQ.remove();
    }

    public void add(E e){
        pQ.add(e);
    }

}
