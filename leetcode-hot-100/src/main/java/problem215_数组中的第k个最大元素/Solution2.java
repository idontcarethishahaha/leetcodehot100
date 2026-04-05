package problem215_数组中的第k个最大元素;

import java.util.PriorityQueue;

//如果不要求严格 O (n)，小顶堆是更稳定的写法
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
