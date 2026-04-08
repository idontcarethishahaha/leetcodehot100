package problem448;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026/4/8 22:35
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 第一次遍历：标记出现过的数字
        for (int i = 0; i < nums.length; i++) {
            // 取绝对值，避免之前的标记影响当前计算
            int index = Math.abs(nums[i]) - 1;
            // 将对应位置的数设为负数，表示该数字已出现
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> res = new ArrayList<>();
        // 第二次遍历：收集未出现的数字（对应位置为正数）
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 下标+1 就是缺失的数字
                res.add(i + 1);
            }
        }
        return res;
    }
}
