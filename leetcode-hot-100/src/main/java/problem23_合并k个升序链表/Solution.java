package problem23_合并k个升序链表;

// 链表节点定义
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    // 分治：合并[l, r]区间的链表
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l]; // 区间只有一个链表，直接返回
        if (l > r) return null;     // 区间为空，返回空
        int mid = (l + r) >> 1;     // 二分中点
        // 递归合并左右两部分，再合并结果
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    // 合并两个有序链表（你已经掌握的基础方法）
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a != null ? a : b;
        return dummy.next;
    }
}