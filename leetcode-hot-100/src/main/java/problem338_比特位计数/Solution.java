package problem338_比特位计数;

//DP  最高有效位
class Solution {
    public int[] countBits(int n) {
        // 1. 初始化结果数组，长度 n+1，bits[0] 默认是 0（0的二进制1的个数就是0）
        int[] bits = new int[n + 1];

        // 2. highBit：记录当前遇到的「最高有效位」（也就是2的幂次，如1,2,4,8...）
        int highBit = 0;

        // 3. 从1遍历到n，计算每个数的1的个数
        for (int i = 1; i <= n; i++) {
            // 4. 判断 i 是否是 2 的幂次（核心技巧：i & (i-1) == 0）
            if ((i & (i - 1)) == 0) {
                highBit = i; // 如果是2的幂次，更新最高有效位
            }
            // 5. 核心递推公式：bits[i] = bits[i - highBit] + 1
            bits[i] = bits[i - highBit] + 1;
        }

        return bits;
    }
}

//DP 最低有效位
/*
class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}

 */
