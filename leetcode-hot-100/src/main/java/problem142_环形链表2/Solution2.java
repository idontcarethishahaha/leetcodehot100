package problem142_环形链表2;

// 解法二，快慢指针
class Solution2 {
   public ListNode detectCycle(ListNode head) {
       ListNode slow=head,fast=head;
       while(fast!=null && fast.next!=null){
           //快指针速度是 2 倍，一定会在环内追上慢指针
           slow=slow.next;//慢指针每次走一步
           fast=fast.next.next;//快指针每次走两步
           if(slow==fast){//快慢指针相遇，说明有环
               ListNode t=head;
               while(t!=slow){
                   t=t.next;//t和slow每次走1步，直到相遇
                   slow=slow.next;
               }
               //相遇点就是环的入口，直接返回
               return t;
           }
       }
       return null;
   }
}
