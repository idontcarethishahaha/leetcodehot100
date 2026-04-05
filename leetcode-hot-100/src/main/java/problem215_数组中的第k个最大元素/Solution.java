package problem215_数组中的第k个最大元素;

// 快速选择
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    // 快速选择：在[left, right]区间找第k大元素
    private int quickSelect(int[] nums, int left, int right, int k) {
        // 随机选择基准，避免最坏情况
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = nums[pivotIndex];
        // 交换基准到末尾，方便划分
        swap(nums, pivotIndex, right);

        // 三指针划分：[left, l-1] > pivot, [l, r-1] == pivot, [r, right] < pivot
        int l = left, r = right;
        int i = left;
        while (i <= r) {
            if (nums[i] > pivot) {
                swap(nums, l++, i++);
            } else if (nums[i] < pivot) {
                swap(nums, r--, i);
            } else {
                i++;
            }
        }

        // 判断目标位置
        if (k <= l - left) {
            // 目标在大于pivot的区间[left, l-1]
            return quickSelect(nums, left, l - 1, k);
        } else if (k > r - left + 1) {
            // 目标在小于pivot的区间[r, right]
            return quickSelect(nums, r, right, k - (r - left));
        } else {
            // 目标在等于pivot的区间，直接返回
            return pivot;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}