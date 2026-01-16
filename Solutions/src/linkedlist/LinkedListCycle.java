/**
Lc 141 : Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Approach: Tortoise Hare Algorithm / Floyd’s Cycle Detection

 TC: O(n)
 SC:O(1)
*/


package linkedlist;

public class LinkedListCycle {

    /**
     *
     * @param a - LinkedList Input
     * @return boolean - cycle exists or not
     */
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

    //re-visit
    public boolean hasCycle(ListNode head) {

        if(head==null || head.next==null)
        {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow)
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
