import java.util.*;

// A priority queue.
public class PriorityQueue<E> {
    public ArrayList<E> heap = new ArrayList<>();
    private final Comparator<E> comparator;
    private final HashMap<E, Integer> hashish = new HashMap<>();

    public PriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // Returns the size of the priority queue.
    public int size() {
        return heap.size();
    }

    // Adds an item to the priority queue.
    public void add(E x) {
        heap.add(x);
        siftUp(heap.size() - 1);
    }

    // Returns the smallest item in the priority queue.
    // Throws NoSuchElementException if empty.
    public E getHighestPrioElem() {
        if (size() == 0)
            throw new NoSuchElementException();

        return heap.get(0);
    }

    // Removes the smallest item in the priority queue.
    // Throws NoSuchElementException if empty.
    public void deleteHighestPrioElem() {
        if (size() == 0)
            throw new NoSuchElementException();

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (heap.size() > 0) siftDown(0);
    }

    // Sifts a node up.
    // siftUp(index) fixes the invariant if the element at 'index' may
    // be less than its parent, but all other elements are correct.
    private void siftUp(int index) {
        E value = heap.get(index);
        while (!(heap.get(parent(index)) == heap.get(index))) {
            int parentIndex = parent(index);
            E parentValue = heap.get(parentIndex);
            if (comparator.compare(parentValue, value) > 0) {
                heap.set(index, parentValue);
                updateHash(parentValue, index);
                index = parentIndex;
            } else break;
        }
        heap.set(index, value);
        updateHash(value, index);
    }

    private void updateHash(E value, int index) {
        if (hashish.isEmpty() || (!hashish.containsKey(value))) {
            hashish.put(value, index);
        } else {
            hashish.replace(value, index);
        }
    }

    // Sifts a node down.
    // siftDown(index) fixes the invariant if the element at 'index' may
    // be greater than its children, but all other elements are correct.
    private void siftDown(int index) {
        E value = heap.get(index);

        // Stop when the node is a leaf.
        while (leftChild(index) < heap.size()) {
            int left = leftChild(index);
            int right = rightChild(index);

            // Work out whether the left or right child is smaller.
            // Start out by assuming the left child is smaller...
            int child = left;
            E childValue = heap.get(left);

            // ...but then check in case the right child is smaller.
            // (We do it like this because maybe there's no right child.)
            if (right < heap.size()) {
                E rightValue = heap.get(right);
                if (comparator.compare(childValue, rightValue) > 0) {
                    child = right;
                    childValue = rightValue;
                }
            }

            // If the child is smaller than the parent,
            // carry on downwards.
            if (comparator.compare(value, childValue) > 0) {
                heap.set(index, childValue);
                updateHash(childValue, index);
                index = child;
            } else break;
        }

        heap.set(index, value);
        updateHash(value, index);
    }

    public void updateElement(E newE, E oldE) {
        if (!(hashish.get(oldE) == null)) {
            int ind = hashish.get(oldE);
            heap.set(ind, newE);
            hashish.remove(oldE);
            hashish.put(newE, ind);
            if (comparator.compare(oldE, newE) > 0) {
                siftUp(ind);
            } else {
                siftDown(ind);
            }
        }
    }


    // Helper functions for calculating the children and parent of an index.
    private final int leftChild(int index) {
        return 2 * index + 1;
    }

    private final int rightChild(int index) {
        return 2 * index + 2;
    }

    private final int parent(int index) {
        return (index - 1) / 2;
    }

    public String showHeap() {

        StringBuilder op = new StringBuilder();

        ArrayList<E> tempHeap = new ArrayList<>(heap);

        PriorityQueue<E> tempPQ = new PriorityQueue<>(comparator);

        tempPQ.heap = tempHeap;

        while (tempPQ.size() > 0) {
            op.append(tempPQ.getHighestPrioElem().toString()).append(", ");
            tempPQ.deleteHighestPrioElem();
        }

        return op.toString();

    }

    public HashMap<E, Integer> getHashish() {
        return new HashMap<>(hashish);
    }
}
