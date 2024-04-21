// MyQueue using MyLinkedList
public class MyQueue<E> {
    private MyLinkedList<E> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }

    public E peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
