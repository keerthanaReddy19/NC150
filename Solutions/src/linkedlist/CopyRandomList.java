package linkedlist;

import java.util.HashMap;

/**
LC 138
 Goal: Deep copy a linked list where each node has next + random pointers

 Key idea:
 Use a HashMap to ensure:
 1) Each original node is copied ONLY ONCE
 2) next/random pointers in the copy point to copied nodes (not originals)

 map: original node -> copied node

 TC: O(n)
 SC: O(n) (HashMap)
 */


public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> track_copy;
    public Node copyRandomList(Node head) {


        track_copy = new HashMap<>();
        Node curr = head;
        Node copyCurr = clone(curr);

        while(curr!=null)
        {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);

            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return track_copy.get(head);
    }

     /*
     create copy of node.
     Store node in HashMap if copy is created
     */

    public Node clone(Node node)
    {
        if(node==null)
        {
            return null;
        }
        if(track_copy.containsKey(node))
        {
            return track_copy.get(node);
        }
        else
        {
            Node copyNode = new Node(node.val);
            track_copy.put(node, copyNode);
            return copyNode;

        }
    }

}
