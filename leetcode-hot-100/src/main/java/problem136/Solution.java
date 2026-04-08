package problem136;

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0; // 初始化为0，利用0^a=a的特性
        for (int num : nums) {
            res ^= num; // 依次异或数组中的每个元素
        }
        return res;
    }
}