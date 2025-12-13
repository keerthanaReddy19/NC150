package linkedlist;

import java.util.PriorityQueue;

public class SortList {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ListNode current = head;

        while(current!=null)
        {
            pq.add(current.val);
            current = current.next;

        }
        current = head;

        while(!pq.isEmpty())
        {
            current.val = pq.poll();
            current = current.next;
        }
        return head;
    }
}
