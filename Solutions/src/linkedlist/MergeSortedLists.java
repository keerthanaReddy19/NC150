package linkedlist;

/**
LC 21: Given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Time Complexity = O(n + m

Space Complexity = O(1) (auxiliary)
because we reuse the existing nodes and only use a constant number of pointers (dummy, tail, etc.).
 */

class MergeSortedLists {

    /*

    list1 = [1,2,4], list2 = [1,3,4]
            p1               p2

                c N
             1->1->3->4
     */



//    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
//    {
//
//        ListNode dummyHead = new ListNode(-1);
//        ListNode head = dummyHead;
//        ListNode current1 = list1;
//        ListNode current2 = list2;
//
//        while(current1!=null && current2!=null)
//        {
//
//            if(current1.val<current2.val)
//            {
//                head.next = current1;
//                current1 = current1.next;
//            }
//            else
//            {
//                head.next = current2;
//                current2 = current2.next;
//            }
//            head = head.next;
//
//        }
//        if(current1!=null)
//        {
//            head.next = current1;
//        }
//
//        if(current2!=null)
//        {
//            head.next = current2;
//        }
//
//        return dummyHead.next;
//
//    }




    public static Node<Integer> mergeList(Node<Integer> a, Node<Integer> b)
    {
        if(a == null && b == null)
        {
            return null;
        }

        if(a == null)
        {
            return b;
        }

        if(b == null)
        {
            return a;
        }

        Node<Integer> tail;
        Node<Integer> current2;
        Node<Integer> current1;
        Node<Integer> answer;

        tail = a.value <= b.value ? a : b;
        current1 = tail;
        answer = current1;
        current2 = current1 == a ? b:a;
        current1 = tail.next;

        /*
               a: 1->2->4
               b: 1->3->4

              c1: tail: 1->2->4
              c2: 1->3>4

              1->2-4
              T  c1

              1->3->4
                c2

              1>1 2
              T   c1
         */


        while(current1!=null && current2!=null)
        {
            if(current1.value<current2.value)
            {
                tail.next = current1;
                current1 = current1.next;
                tail = tail.next;
            }
            else {
                tail.next = current2;
                current2 = current2.next;
                tail = tail.next;
            }
        }

        while(current1!=null)
        {
            tail.next = current1;
            current1 = current1.next;
            tail = tail.next;

        }
        while(current2!=null)
        {
            tail.next = current2;
            current2 = current2.next;
            tail = tail.next;

        }

        return answer;
    }


    //revisit
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode list1_pointer = list1;
        ListNode list2_pointer = list2;


        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                tail.next = list1;
                list1 = list1.next;
            }
            else
            {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        while(list1!=null)
        {
            tail = tail.next;
            list1 = list1.next;
        }

        while(list2!=null)
        {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }

        return dummy.next;
    }


    public static void main(String args[]) {
       Node a = new Node<>(1);
        a.next = new Node<>(2);
        a.next.next = new Node<>(4);

       Node b = new Node<>(1);
        b.next = new Node<>(3);
        b.next.next = new Node<>(4);
       /* Node a = null;
        Node b = new Node<>(0); */

        Node<Integer> merged = mergeList(a, b);

        // Print merged list
        Node<Integer> current = merged;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

    }
}
