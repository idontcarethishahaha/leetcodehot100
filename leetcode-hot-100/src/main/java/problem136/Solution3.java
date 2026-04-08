package problem136;

import java.util.Arrays;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026/4/8 22:16
 */
// 排序后遍历法
public class Solution3 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
