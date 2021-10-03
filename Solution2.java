class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = 0;
    int carry = 0;
    ListNode result = new ListNode(-1);
    ListNode head = result;
    while(l1 != null && l2 != null){
      sum = l1.val+l2.val+carry;
      carry = sum/10;
      head.next = new ListNode(sum%10);
      head = head.next;
      l1 = l1.next;
      l2 = l2.next;
    }

    while(l1 != null){
      sum = l1.val+carry;
      carry = sum/10;
      head.next = new ListNode(sum%10);
      head = head.next;
      l1 = l1.next;
    }

    while(l2 != null){
      sum = l2.val+carry;
      carry = sum/10;
      head.next = new ListNode(sum%10);
      head = head.next;
      l2 = l2.next;
    }

    if(carry != 0){
      head.next = new ListNode(carry);
    }

    return result.next;
  }
}