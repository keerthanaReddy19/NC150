package LinkedList;

import java.util.HashMap;
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

