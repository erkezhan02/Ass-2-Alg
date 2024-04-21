// MyMinHeap using MyArrayList
public class MyMinHeap {
    private MyArrayList<Integer> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex) < heap.get(parentIndex)) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public int extractMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int minValue = heap.get(0);
        heap.remove(0);
        if (heap.size() > 0) {
            heap.add(0, heap.remove(heap.size() - 1));
            heapifyDown(0);
        }
        return minValue;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallestIndex)) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallestIndex)) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.remove(i);
        heap.add(i, heap.remove(j - 1));
        heap.add(j, temp);
    }
}
