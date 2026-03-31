package problem55_跳跃游戏;

// 贪心
/*
核心思想：不用纠结每一步具体跳多远，只关注当前能到达的 “最远范围”。

我们遍历数组，不断更新当前能到达的最远距离（rightmost）。
如果在遍历过程中，rightmost 能够覆盖到数组的最后一个位置，说明可以到达；否则无法到达。
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length; // 数组长度
        int rightmost = 0;    // 记录当前能到达的最远下标

        // 遍历数组中的每一个位置
        for (int i = 0; i < n; ++i) {
            // 只有当前位置 i 在可达范围内（<= rightmost），才能更新最远位置
            if (i <= rightmost) {
                // 更新最远位置：取【原来的最远】和【当前位置能跳到的最远 i + nums[i]】的最大值
                rightmost = Math.max(rightmost, i + nums[i]);

                // 如果此时最远位置已经 >= 数组最后一个下标，直接返回 true
                if (rightmost >= n - 1) {
                    return true;
                }
            }
            // 如果 i > rightmost，说明卡住了，永远跳不到后面，循环自然结束
        }
        // 循环结束都没返回 true，说明无法到达最后一个下标
        return false;
    }
}
