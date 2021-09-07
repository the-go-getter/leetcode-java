public class Solution21 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode dummy = new ListNode(-1);
    dummy = head;
    while(l1 != null && l2 != null){
      if(l1.val <= l2.val){
        head.next = new ListNode(l1.val);
        l1 = l1.next;
      } else{
        head.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      head = head.next;
    }

    if(l1 == null){
      head.next =  l2;
    } else if(l2 == null){
      head.next =  l1;
    }

    return dummy.next;
  }
}
