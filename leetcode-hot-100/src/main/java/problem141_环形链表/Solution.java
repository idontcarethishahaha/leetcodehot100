package problem141_环形链表;

/*
一个单链表，若链表中存在环，则返回true

链表最后一个节点的 next 不是 null，而是指向了链表前面的某个节点，导致链表变成一个圈

用 HashSet 记录走过的节点，如果再次遇到同一个节点 → 说明有环
 */

import java.util.HashSet;
import java.util.Set;

class ListNode{
    int x;
    ListNode next;
    ListNode(int x){}
    ListNode(int x,ListNode next){
        this.x = x;
        this.next = next;
    }
}
// hashset 利用不包含重复元素的特性
class Solution {
    public boolean hasCycle(ListNode head) {
        // 创建一个HashSet来保存走过的节点
        Set<ListNode> vis=new HashSet<>();

        // 遍历链表
        while(head!=null){
            // 尝试将当前节点放入集合
            // 若add返回false，说明节点之前已经加过了
            if(!vis.add(head)){
                return true;//发现重复节点，说明有环
            }
            head=head.next;
        }
        return false;//走到null了就说明没环
    }
}
