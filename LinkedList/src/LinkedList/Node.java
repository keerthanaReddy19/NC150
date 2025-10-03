package LinkedList;

public class Node<T> {
    T value;
    Node<T> next;

    Node(T value)
    {
        this.value = value;
        this.next = null;
    }
    Node()
    {
        this.value = null;
        this.next = null;
    }
}
