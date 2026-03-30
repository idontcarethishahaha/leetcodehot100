package problem160;

import java.util.HashSet;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        next=null;
    }
}
// 相交链表，返回相交节点

//解法一，哈希集合
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();

        ListNode cur=headA;//临时指针

        while(cur!=null){//遍历A
            set.add(cur);
            cur=cur.next;
        }
        cur=headB;//重置临时指针，遍历B
        while(cur!=null){
            if(set.contains(cur)){//该节点也有在A链表中出现
                return cur;//返回相交节点
            }
            cur=cur.next;
        }
        return null;//遍历完B没有找到相交节点的话说明没有
    }
}
