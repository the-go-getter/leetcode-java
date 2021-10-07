
// Definition for a Node.
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


class Solution138 {
  public Node copyRandomList(Node head) {
    Node result = new Node(-1);
    Node resultPtr = result;
    Node headPtr = head;
    while(headPtr!=null){
      Node duplicate = new Node(headPtr.val);
      duplicate.next = headPtr.next;
      headPtr.next = duplicate;
      duplicate.random = headPtr;
      headPtr = duplicate.next;
    }

    headPtr = head;
    while(headPtr!=null){
      headPtr.next.random = (headPtr.random!=null)? headPtr.random.next : null;
      headPtr = headPtr.next.next;
    }

    headPtr = head;
    while(headPtr!=null){
      resultPtr.next = headPtr.next;
      headPtr.next = headPtr.next.next;
      headPtr = headPtr.next;
      resultPtr = resultPtr.next;
    }

    return result.next;
  }
}
