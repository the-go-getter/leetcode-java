import java.util.HashMap;

public class Solution146 {
  class LRUCache {
    int capacity;
    int currSize;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.currSize = 0;
      this.head = new Node(-1, -1);
      this.tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
      head.prev = null;
      tail.next = null;
    }

    public int get(int key) {
      if (map.containsKey(key)) {
        removeNode(map.get(key));
        addToHead(map.get(key));
        return map.get(key).val;
      } else {
        return -1;
      }
    }

    public void put(int key, int value) {
      if (!map.containsKey(key)) {
        map.put(key, new Node(key, value));
        addToHead(map.get(key));
        currSize++;
      } else {
        map.get(key).val = value;
        removeNode(map.get(key));
        addToHead(map.get(key));
      }

      while (currSize > capacity) {
        map.remove(tail.prev.key);
        removeNode(tail.prev);
        currSize--;
      }
    }

    public void addToHead(Node mostFreqNode) {
      mostFreqNode.next = head.next;
      head.next.prev = mostFreqNode;
      head.next = mostFreqNode;
      mostFreqNode.prev = head;
    }

    public void removeNode(Node lruNode) {
      lruNode.prev.next = lruNode.next;
      lruNode.next.prev = lruNode.prev;
    }

    class Node {
      Node prev;
      Node next;
      int key;
      int val;

      Node(int key, int val) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.val = val;
      }
    }
  }
}
