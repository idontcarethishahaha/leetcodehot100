package problem206.acm;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    // 反转链表函数
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // 先保存下一个节点
            curr.next = prev;          // 反转当前指针
            prev = curr;               // prev 前移
            curr = next;               // curr 前移
        }
        return prev; // 循环结束 prev 就是新头
    }

    // 将一个数组转化为链表
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        // dummy是一个临时占位节点，虚拟的头
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for (int num : arr) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;//要dummy后面的
    }

    // ==================== ACM 主函数测试 ====================
    public static void main(String[] args) {
//        // 构建链表 1 -> 2 -> 3 -> 4 -> 5
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        int[] nums = {1,2,3,4,5};
        ListNode head = createLinkedList(nums);

        //反转方法 reverseList 写在 Solution 这个类里面，必须创建对象才能使用
        Solution s = new Solution();
        //用造好的解题工具s调用反转链表的方法
        ListNode newHead = s.reverseList(head);//新的头节点newHead

        // 输出反转后：5 4 3 2 1
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;//遍历链表，打印每一个数字
        }
    }
}