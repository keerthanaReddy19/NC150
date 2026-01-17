package linkedlist;
/*
LC 328
 */
public class OddEven {
    public ListNode oddEvenList(ListNode head) {

        if(head==null)
        {
            return null;
        }

        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;

        while(even!=null && even.next!=null)
        {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;

        }

        odd.next = evenHead;

        return head;



    }
}
