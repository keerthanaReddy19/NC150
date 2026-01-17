package linkedlist;

import java.util.HashMap;

/**
 * LC 146
 * TC: O(1), SC: O(c)
 */
public class LRUCache {

    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    // Doubly linked list node definition
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     *   Constructor: initialize cache with given capacity
     *   and create dummy head & tail nodes for easier insert/remove
     */
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }




    /**
     * Adds a given node right after head.
     * This makes it the "most recently used" element.
     */
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;

    }

    /**
     * Removes a given node from the doubly linked list
     * by connecting its previous and next neighbors directly.
     */
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;

    }

    /**
     * Returns the value of the key if it exists, else -1.
     * Moves the accessed node to the head (most recently used).
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }

    /**
     * Inserts or updates a key-value pair.
     * If key exists: update value & move node to head.
     * If key does not exist:
     *    - If cache is full: evict least recently used (tail.prev).
     *    - Insert new node at head.
     */
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                Node lastNode = tail.prev;
                remove(lastNode);
                map.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        } else {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        }

    }


    //revisit
//    class LRUCache
//    {
//        int capacity;
//        Node head;
//        Node tail;
//        HashMap<Integer, Node> map_data = new HashMap<>();
//
//        class Node
//        {
//            int key, value;
//            Node prev, next;
//
//            Node(int key, int value)
//            {
//                this.key = key;
//                this.value = value;
//            }
//        }
//
//        public LRUCache(int capacity)
//        {
//            this.capacity = capacity;
//            this.head = new Node(-1,-1);
//            this.tail = new Node(-1,-1);
//            head.next = tail;
//            tail.prev = head;
//        }
//
//
//        public void removeNode(Node node)
//        {
//            /*
//            update node prev
//            update node next
//            */
//            node.next.prev = node.prev;
//            node.prev.next = node.next;
//
//            node.prev = null;
//            node.next = null;
//
//        }
//
//        public void addToHead(Node node)
//        {
//            /*
//            update head node
//            update node prev, next
//            */
//
//            node.next = head.next;
//            node.prev = head;
//            head.next.prev = node;
//            head.next = node;
//
//        }
//
//
//
//        public int get(int key)
//        {
//        /*
//          look for key in HashMap, if present: get the node ref. else: -1
//        - Remove the node from DLL, and add it in front (next to head)
//        - Fetch the node.value from DLL
//        */
//
//            if(map_data.containsKey(key))
//            {
//                Node node = map_data.get(key);
//                removeNode(node);
//                addToHead(node);
//                return node.value;
//            }
//            else
//            {
//                return -1;
//            }
//        }
//
//        public void put(int key, int value)
//        {
//      /*
//      if key present in map:
//      -Fetch its node ref.
//      -remove node from DLL
//      -Add node to head
//      -update node.val to new value;
//
//      if key not preesent:
//      -check map size;
//      if within capacity:
//      -create new node, add to head
//      -add node to hashmap.
//      else:
//      remove node prev to tail,
//        -create new node, add to head
//      -add node to hashmap.
//      */
//
//            if(map_data.containsKey(key))
//            {
//                Node node = map_data.get(key);
//                node.value = value;
//                removeNode(node);
//                addToHead(node);
//            }
//            else
//            {
//                if(map_data.size()<capacity)
//                {
//                    Node node = new Node(key, value);
//                    addToHead(node);
//                    map_data.put(key, node);
//                }
//                else
//                {
//                    Node last_node = tail.prev;
//                    removeNode(last_node);
//                    map_data.remove(last_node.key);
//                    Node node = new Node(key, value);
//                    addToHead(node);
//                    map_data.put(key, node);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println("Get 1: " + cache.get(1)); // returns 10

        cache.put(3, 30);
        System.out.println("Get 2: " + cache.get(2)); // returns -1

        cache.put(4, 40);
        System.out.println("Get 1: " + cache.get(1)); // returns -1
        System.out.println("Get 3: " + cache.get(3)); // returns 30
        System.out.println("Get 4: " + cache.get(4)); // returns 40
    }
}

