package linkedlist;

import static linkedlist.ReverseLinkedList.reverseList;

public class IsPallindrome {

    /*
    Fast and Slow pointer : To find the middle
    And then reverse from middle
     */

    public boolean isPalindrome(ListNode head)
    {

        ListNode fast = head;
        ListNode slow = head;
        ListNode firstHalfHead = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid_node = slow;

        if(fast!=null)
        {
            slow = slow.next;

        }

        ListNode secondHalfHead = reverseList(slow);

        //compare
        while(secondHalfHead!=null)
        {
            if(firstHalfHead.val!=secondHalfHead.val)
            {
                break;
            }
            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;

        }
        return true;



    }
}
