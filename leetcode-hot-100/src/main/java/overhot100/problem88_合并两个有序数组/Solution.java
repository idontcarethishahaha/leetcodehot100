package overhot100.problem88_合并两个有序数组;

// 合并2个有序数组
/*
两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目

合并nums2到nums1中，保持非递减
 */

// 双指针
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;//nums1 有效元素最后一位
        int j=n-1;//nums2 有效元素最后一位
        int k=m+n-1;//合并后数组的最后一位下标

        //从后往前放，大的有i西安
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                // 先使用k的当前值，放到下标k，放完k=k-1,后自减
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--]=nums2[j--];//若nums2中还有剩余，就全部复制到前面
        }
    }
}

