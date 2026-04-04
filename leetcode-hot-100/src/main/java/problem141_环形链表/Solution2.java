package problem141_环形链表;

// 快慢指针
class Solution2 {
  public boolean hasCycle(ListNode head) {
      ListNode fast=head;
      ListNode slow=head;
      while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
          if(fast==slow) return true;//相遇=有环
      }
      return false;
  }
}
