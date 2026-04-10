package problem338_比特位计数;

//奇偶性递推 O (n)
class Solution3 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 偶数：i/2的1的个数；奇数：i/2的1的个数+1
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
