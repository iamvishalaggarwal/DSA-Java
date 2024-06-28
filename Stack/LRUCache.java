package Stack;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
 */

/*
 * Algo - 
 * - we need to use a double LL (which has key and value) and hashmap (which stores key and node address)
 * - initialise the LL with head and tail node, in which head points to the tail
 * - order -> recently used at left and least recently used at right (decreasing order left to right)
 * - when we get the element, then it will become recently used and we put it in the front (ie, after head)
 * - if the key is present while put, then we remove the prev key and insert the key with new value (in both DLL and hash map)
 * - if key is not present then we directly insert the new key in the DLL after head (as it is recently used) and also in the hashmap
 * - we also need to check the capacity while insertion, if capacity reached we need to remove the least recently used i.e, prev node of tail and then perform insert operation
 * 
 * TC: O(1)
 */
class LRUCache { // LRU = least recently used
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}