public class MyStack<E> {
    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}