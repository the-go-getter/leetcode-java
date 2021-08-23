import java.util.PriorityQueue;



public class Solution23 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> numbers = new PriorityQueue<>((a,b) -> a.val-b.val);

    for(ListNode head: lists){
      while(head!=null){
        numbers.add(head);
        head = head.next;
      }
    }

    ListNode dummmy = new ListNode(-1);
    ListNode pointer = dummmy;
    while(!numbers.isEmpty()){
      pointer.next = new ListNode(numbers.poll().val);
      pointer = pointer.next;
    }
    return dummmy.next;
  }
}
