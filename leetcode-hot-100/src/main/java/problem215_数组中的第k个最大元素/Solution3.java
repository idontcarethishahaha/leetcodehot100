package problem215_数组中的第k个最大元素;

// 桶排序
class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }
}
/*
nums[i] ∈ [-10000, 10000]
范围很小！所以可以用桶排序。
 */
