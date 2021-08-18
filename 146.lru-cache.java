/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
import java.util.HashMap;
class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node() {
            this.key = -1;
            this.val = -1;
        }
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int len = 0;

    private final int cap;

    private final Node head = new Node();

    private final Node tail = new Node();

    private final HashMap<Integer,Node> tab;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.tab = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = tab.get(key);
        if(node == null) {
            return -1;
        }
        moveToLatest(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = tab.get(key);
        if(node != null) {
            node.val = value;
            moveToLatest(node);
        } else {
            Node newNode = new Node(key, value);
            moveToLatest(newNode);
            tab.put(key, newNode);
            len++;
            removeOldest();
        }
    }

    private void moveToLatest(Node node) {
        if(node == head || node == tail) {
            return;
        }
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeOldest() {
        if(len > cap) {
            Node del = head.next;
            del.next.prev = head;
            head.next = del.next;
            del.next = null;
            del.prev = null;
            tab.remove(del.key);
            len = cap;
        }
    }
}

import java.util.LinkedHashMap;
import java.util.Map;
class LRUCacheWithLinkedHashMap {

    private final LinkedHashMap<Integer,Integer> cap;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.cap = new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.cap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.cap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

