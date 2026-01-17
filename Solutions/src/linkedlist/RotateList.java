package linkedlist;


/*
Rotate List:
- Keep a tail pointer.
- Compute length of list.
- Compute shift = k % length.
- If shift == 0 → return head.
- Make list circular: tail.next = head.
- Compute pivot = length - shift (this is the position of newHead, 1-indexed).
- Move newTail pivot-1 steps from head.
- newHead = newTail.next, then newTail.next = null.
- Return newHead.

TC: O(n), SC O(1)
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
        {
            return head;
        }

        ListNode tail;
        tail = head;

        int length = 1;

        while(tail.next!=null)
        {
            length++;
            tail = tail.next;
        }

        int pivot = length - (k%length);

        if(k%length==0)
        {
            return head;
        }

        tail.next = head;

        ListNode newTail = head;

        int count = 1;
        while(count<=pivot-1 && newTail.next!=null)
        {
            count++;
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;


        return newHead;

    }
}
