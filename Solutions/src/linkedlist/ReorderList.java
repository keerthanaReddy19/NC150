package linkedlist;

/**
 * LC143: You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 * Approach:
 * Find Middle Node O(n)
 * Reverse second half O(n)
 * Merge 2 halves O(n)
 * SC: O(1) TC O(n)
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

    //re-visit (right parameters)
    public void reorderList(ListNode head) {

        //Find Middle Node - Fast n Slow pointer Approach

        if(head==null)
        {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode middle_node;


        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second part of the list (from middle node)

        //starting point: slow

        ListNode prev = null;
        ListNode current = slow;
        ListNode next;

        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }



        //Merge first half (head) and second half (prev)

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        dummy.next = head;
        int index = 0;


        while(head!=null && prev!=null)
        {
            //even-index
            if(index%2==0)
            {
                tail.next = head;
                tail = tail.next;
                head = head.next;
                index++;
            }
            else
            {
                tail.next = prev;
                tail = tail.next;
                prev = prev.next;
                index++;
            }
        }

        if(head!=null)
        {
            tail = head.next;
        }
        if(prev!=null)
        {
            tail = prev.next;
        }

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
