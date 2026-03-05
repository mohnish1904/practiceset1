package org.example.LeetCode;


import java.util.HashMap;

public class LRUCache {

    public class Node {
        Integer key, value;
        Node next, prev;
        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    // initialize map fro O(1) retrieval
    Integer capacity = 5;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    // initialize head and tail with dummy node to handle null pointers

    public LRUCache(Integer capacity){
        this.capacity = capacity;
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    // put
    void put(Node current){

        if (map.containsKey(current.key)){
            Node existing = map.remove(current.key);
            removeNode(existing);
        }

        if (map.size() == capacity){
            removeNode(tail.prev);
        }

        insertToHead(current);
        map.put(current.key, current);
    }

    private void insertToHead(Node current) {
        Node temp = head.next;
        head.next = current;
        current.prev = head;

        current.next = temp;
        temp.prev = current;
    }

    // remove
    void removeNode(Node current){
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    //get
    Integer get(int key){
        if (!map.containsKey(key))
            return -1;
        removeNode(map.get(key));
        insertToHead(map.get(key));
        return map.get(key).value;
    }

}
