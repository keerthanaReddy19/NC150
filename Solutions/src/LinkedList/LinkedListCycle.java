/*
Lc 141 : Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Approach: Tortoise Hare Algorithm / Floyd’s Cycle Detection
*/


package LinkedList;

public class LinkedListCycle {

    public static boolean detectCycle(Node<Integer> a)
    {
        Node<Integer> slow = a;
        Node<Integer> fast = a;

        while (fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[])
    {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(5);
        Node<Integer> c = new Node<>(5);
        Node<Integer> d = new Node<>(5);
        Node<Integer> e = new Node<>(5);
        a.next = b;
        b.next = c;
        c.next=  d;
        // d.next = c;
        System.out.println(detectCycle(a));

    }
}
