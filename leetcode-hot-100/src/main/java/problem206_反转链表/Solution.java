package problem206_反转链表;

// 反转链表

//链表结构
class ListNode{
    int val;//链表数据域
    ListNode next;//链表指针域，指向下一个节点的指针
    ListNode(){}
    ListNode(int x){
        this.val = x;
    }
    ListNode(int x,ListNode next){
        this.val=x;
        this.next=next;
    }
}

// 从链表头开始，一个个将节点反过来
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev=null;//前一个节点，一开始是null，最终会变成新链表的头
        ListNode curr=head;//当前节点，从头开始
        // List next 临时保存下一个节点

        while(curr!=null){
            ListNode next=curr.next;//先保存下一个节点，别让链表断了
            curr.next=prev;//将当前节点指向前一个
            prev=curr;//prev往前走
            curr=next;//curr往前走
        }
        return prev;//新的头节点
    }
}
