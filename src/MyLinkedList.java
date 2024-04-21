// MyLinkedList implementation
public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E element;
        MyNode next;
        MyNode prev;

        MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Other constructors, if needed

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode newNode = new MyNode(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            MyNode prevNode = getNode(index - 1);
            MyNode nextNode = prevNode.next;
            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            if (nextNode != null) {
                nextNode.prev = newNode;
            }
        }
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode removedNode;
        if (size == 1) {
            removedNode = head;
            head = null;
            tail = null;
        } else if (index == 0) {
            removedNode = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            MyNode prevNode = getNode(index - 1);
            removedNode = prevNode.next;
            MyNode nextNode = removedNode.next;
            prevNode.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        }
        size--;
        return removedNode.element;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
