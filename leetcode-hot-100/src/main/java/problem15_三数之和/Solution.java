package problem15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和，双指针
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 先排序
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 双指针，目标是找到 nums[l] + nums[r] = -nums[i]
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // 跳过重复元素
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k=0; k<nums.length-2; k++){
            if(nums[k]>0) break;
            if(k>0&&nums[k]==nums[k-1]) continue;
            int i=k+1, j=nums.length-1;
            while(i<j){
                int sum = nums[k]+nums[i]+nums[j];
                if(sum<0) i++;
                else if(sum>0) j--;
                else{
                    res.add(Arrays.asList(nums[k],nums[i++],nums[j--]));
                    while(i<j&&nums[i]==nums[i-1])i++;
                    while(i<j&&nums[j]==nums[j+1])j--;
                }
            }
        }
        return res;
    }
}
 */