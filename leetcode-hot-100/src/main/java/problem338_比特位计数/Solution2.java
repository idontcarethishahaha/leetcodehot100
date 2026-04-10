package problem338_比特位计数;

//Brian Kernighan 算法（O (n log n)，优化版）
class Solution2 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int x = i;
            int count = 0;
            while (x > 0) {
                x &= x - 1; // 消去最低位的1
                count++;
            }
            bits[i] = count;
        }
        return bits;
    }
}
/*
class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
 */
