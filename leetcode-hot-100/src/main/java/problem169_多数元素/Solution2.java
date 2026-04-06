package problem169_多数元素;

import java.util.HashMap;
import java.util.Map;

// 哈希表，效率低些
class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // 提前判断，优化效率
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        return -1; // 题目保证一定有解，不会走到这里
    }
}
