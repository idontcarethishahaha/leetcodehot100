package problem23_合并k个升序链表;

import java.util.PriorityQueue;
import java.util.Comparator;

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. 定义小根堆，按节点值升序排列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        // 2. 把所有非空链表的头节点入堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // 3. 虚拟头节点，串起结果链表
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 4. 循环取堆顶最小节点
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll(); // 取出当前最小节点
            cur.next = minNode;           // 接到结果链表
            cur = cur.next;
            // 把该节点的下一个节点入堆（如果不为空）
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
