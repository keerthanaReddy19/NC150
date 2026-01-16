package linkedlist;

import java.util.*;

/**
LC 23

Time Complexity: O(N log K)
We process N total nodes across all lists.
At any time, the priority queue contains at most K nodes (one from each list).
Each poll and add operation on the priority queue takes O(log K) time.
Since each node is inserted and removed once, the total time is O(N log K).

Space Complexity:
Heap stores at most k nodes → O(k)
Output list uses existing nodes → no extra space beyond the heap.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {


        //Min-Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode result = new ListNode();

        if (lists == null || lists.length == 0) {
            return null;
        }


        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;


        while (!pq.isEmpty()) {
            ListNode node = pq.remove();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                pq.add(node.next);
            }

        }

        return dummy.next;

    }

}
