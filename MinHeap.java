import java.util.PriorityQueue;

public class MinHeap<E extends Comparable> {
    public PriorityQueue<E> pQ;
    MinHeap(int initialValue) {
        pQ = new PriorityQueue(initialValue, new MinComparator());
    }

    public E findMin(){
        return pQ.peek();
    }

    public void deleteMin(){
        pQ.remove();
    }

    public void add(E e){
        pQ.add(e);
    }

}