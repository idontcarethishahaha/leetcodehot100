package problem136;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026/4/8 22:15
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
