package problem21_合并2个有序链表;

/*
合并两个有序链表，在原有链表上操作，节点结构自己定义，输入两个链表，自己设定入参出参，不可创建新的节点
 */

public class MergeTwoSortedLists {

    // ===================== 1. 自定义链表节点结构 =====================
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // ===================== 2. 核心方法：原地合并，不新建节点 =====================
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 边界：如果一个链表为空，直接返回另一个（不用合并）
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 确定哪个链表是【头更小的主链表】
        ListNode head; // 最终要返回的头
        ListNode cur;  // 用来串链表的指针

        if (l1.val <= l2.val) {
            head = l1;
            cur = l1;
            l1 = l1.next;
        } else {
            head = l2;
            cur = l2;
            l2 = l2.next;
        }

        // ===================== 核心：原地修改 next 指针，不创建新节点 =====================
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;  // 直接接上原节点
                cur = cur.next; // 移动指针
                l1 = l1.next;
            } else {
                cur.next = l2;  // 直接接上原节点
                cur = cur.next;
                l2 = l2.next;
            }
        }

        // 把剩余部分直接接上（依旧是原链表节点）
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return head;
    }

    // ===================== 3. 测试：自己设定入参出参 =====================
    public static void main(String[] args) {
        // 构造链表1：1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // 构造链表2：2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode merged = solution.mergeTwoLists(l1, l2);

        // 打印结果：1 2 3 4 5 6
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
