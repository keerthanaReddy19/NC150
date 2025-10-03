package LinkedList;

public class ReverseLinkedList {
    /*  h
     N  1 -> 2 -> 3
             P    c
        nullN <- 1 <- 2 <- 3

                       c
        N <- 1 <- 2 <- 3
                  P    h


*/

public static Node<Integer> reverseList(Node<Integer> head)
{
    Node<Integer> nullNode = null;
    Node<Integer> prev = nullNode;
    Node<Integer> current = head;


    while(current!=null)
    {
        Node<Integer> next = current.next;
        current.next = prev;
        prev = current;
        current = next;

    }
    return prev;
}

public static void main(String[] args)
{
    Node<Integer> a = new Node<>(5);
    Node<Integer> b = new Node<>(4);
    Node<Integer> c = new Node<>(3);
    Node<Integer> d = new Node<>(2);
    Node<Integer> e = new Node<>(1);
    a.next = b;
    b.next = c;
    c.next=  d;
    // d.next = c;

    Node<Integer> answer = reverseList(a);
    while(answer!=null)
    {
        System.out.print(answer.value + " ");
        answer = answer.next;
    }
}


}
