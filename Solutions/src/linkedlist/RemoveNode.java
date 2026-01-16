package linkedlist;

/**
 * LC19: Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * TC: O(L)
 * SC: O(1)
 */
public class RemoveNode {
    /**
     *
     * @param head LinkedList
     * @param n index
     * @return head
     */
    public static Node<Integer> removeNthNode(Node<Integer> head, int n) {

        Node<Integer> current = head;
        Node<Integer> prev = null;

        if (n == 0) {
            head = head.next;
        }

        int index = 0;

        while (index <= n) {
            prev = current;
            current = current.next;
            index++;
            if (index == n) {
                prev.next = current.next;
            }
        }

        return head;
    }


    public static Node<Integer> removeNthNodeFromEnd(Node<Integer> head, int n) {

        int length = 0;

        Node<Integer> curr = head;
        //Node<Integer> prev = null;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int preindex = length - n;
        Node<Integer> c = head;
        int index = 1;
        if (index == preindex) {
            head.next = null;
        }
        while (index < preindex) {
            index++;
            c = c.next;
        }
        if (index == preindex) {
            c.next = c.next.next;
        }

        return head;
    }

    //re-visit
    public ListNode removeNthFromEnd(ListNode head, int n)
    {

        ListNode dummy = new ListNode(-1);

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        dummy.next = head;


        for(int i=0;i<n;i++)
        {
            p2 = p2.next;
        }

        //Move both
        while(p2.next!=null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode to_delete = p1.next;
        p1.next = to_delete.next;

        return dummy.next;
    }


    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(4);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(2);
        Node<Integer> e = new Node<>(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;


        // Node<Integer> answer = removeNthNode(a, 2);
        Node<Integer> answer = removeNthNodeFromEnd(a, 2);
        while (answer != null) {
            System.out.print(answer.value + " ");
            answer = answer.next;
        }
    }
}
