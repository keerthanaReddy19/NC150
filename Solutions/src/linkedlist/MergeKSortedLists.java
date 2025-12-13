package linkedlist;

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {


        ListNode dummyhead = new ListNode();
        ListNode head = dummyhead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a , b) -> Integer.compare(a.val, b.val));

        for(ListNode list: lists)
        {
            if(list!=null)
            {
                pq.add(list);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode node =  pq.poll();
            head.next = node;
            head = head.next;

            if(node.next!=null)
            {
                pq.add(node.next);
            }
        }

        return dummyhead.next;
    }
}
