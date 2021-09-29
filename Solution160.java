public class Solution160 {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int sizeA = 0;
    int sizeB = 0;

    ListNode dummy = headA;
    while(dummy!=null){
      dummy = dummy.next;
      sizeA++;
    }

    dummy = headB;
    while(dummy!=null){
      dummy=dummy.next;
      sizeB++;
    }

    int sizeDiff = 0;
    if(sizeA < sizeB){
      sizeDiff = sizeB - sizeA;
      while(sizeDiff-- > 0){
        headB = headB.next;
      }
    }else {
      sizeDiff = sizeA - sizeB;
      while(sizeDiff-- > 0){
        headA = headA.next;
      }
    }



    while(headA != headB){
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }
}