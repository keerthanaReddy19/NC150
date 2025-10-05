package LinkedList;
/**
 * LC2: given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class LinkedListAdd {

    /**
     * @param l1 list1
     * @param l2 list2
     * @return sum of list1 and list2
     */
    public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> SumList = new Node<>(0);
        Node<Integer> c1 = l1;
        Node<Integer> c2 = l2;
        Node<Integer> tail = SumList;
        int carry = 0;


        while (c1 != null || c2 != null || carry > 0) {
            int value1 = c1 != null ? c1.value : 0;
            int value2 = c2 != null ? c2.value : 0;

            int sum = value1 + value2 + carry;
            int digit = sum < 10 ? sum : sum % 10;
            carry = sum / 10;

            tail.next = new Node<>(digit);
            tail = tail.next;

            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;
        }


        return SumList.next;

    }

    public static void main(String args[]) {
        Node a = new Node<>(1);
        a.next = new Node<>(2);
        a.next.next = new Node<>(4);

        Node b = new Node<>(9);
        b.next = new Node<>(3);
        //b.next.next = new Node<>(4);


        Node<Integer> solution = addTwoNumbers(a, b);

        Node<Integer> current = solution;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;

        }

    }
}
