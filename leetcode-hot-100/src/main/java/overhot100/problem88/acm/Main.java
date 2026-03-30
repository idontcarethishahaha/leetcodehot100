package overhot100.problem88.acm;

import java.util.*;

public class Main {
    // 合并两个有序数组（从后往前双指针）
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // nums1 有效元素最后一位
        int j = n - 1;  // nums2 最后一位
        int k = m + n - 1;  // 合并后最后一位下标

        // 从后往前放，大的优先
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // 如果 nums2 还有剩余，全部复制到前面
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // ==================== ACM 主函数 ====================
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        // 调用合并
        merge(nums1, m, nums2, n);

        // 输出结果
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}