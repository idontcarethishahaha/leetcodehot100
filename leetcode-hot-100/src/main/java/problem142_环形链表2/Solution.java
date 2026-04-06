package problem142_环形链表2;

import java.util.HashSet;
import java.util.Set;

// 单链表节点
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
// 解法一，哈希表
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p=head;
        Set<ListNode> vis=new HashSet<>();
        while(p!=null){
            if(vis.contains(p)){
                return p;
            }else{
                vis.add(p);
            }
            p=p.next;
        }
        return null;
    }
}
