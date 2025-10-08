package linkedlist;

/**
 * LC143: You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {

    /**
     *
     * @param head1 list1
     * @param head2 list2
     * @return head1 reordered list
     */
    public static Node<Integer> reorder(Node<Integer> head1, Node<Integer> head2)
    {

        if(head1==null&&head2==null)
        {
            return null;
        }
        if(head1==null)
        {
            return head2;
        }
        if(head2==null)
        {
            return head1;
        }


        Node<Integer> T = head1;
        Node<Integer> c1 = head1.next;
        Node<Integer> c2 = head2.next;
        T.next = head2;
        T = T.next;
        int count = 0;

        while(c1!=null && c2!=null) {
            if (count % 2 == 0) {
                T.next = c1;
                c1 = c1.next;
                T = T.next;
                count++;
            } else {
                T.next = c2;
                c2 = c2.next;
                T = T.next;
                count++;
            }
        }
            if(c1!=null)
            {
                T.next = c1;
            }
            if(c2!=null)
            {
                T.next = c2;
            }

        return head1;
    }

    public static void main(String[] args)
    {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(4);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(1);
        Node<Integer> e = new Node<>(2);
        a.next = c;
        c.next = d;
        b.next =  e;
       //a: 5->3->1 b: 4->2  5->4->3->2->1
        Node<Integer> final_answer = reorder(a,b);
        while(final_answer!=null)
        {
            System.out.println(final_answer.value);
            final_answer = final_answer.next;
        }

    }

}
