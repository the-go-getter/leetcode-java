public class Solution206 {
  public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr;
    while(head != null){
      curr = head.next;
      head.next = prev;
      prev  = head;
      head = curr;

    }
    return prev;
  }
}
