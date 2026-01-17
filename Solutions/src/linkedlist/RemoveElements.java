package linkedlist;

/**
 * LC 203
 * O(n), O(1)
 */

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode curr = head;
        ListNode tail = curr;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;


        while(curr!=null)
        {
            if(curr.val==val)
            {
                prev.next = curr.next;
                curr = curr.next;


            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
