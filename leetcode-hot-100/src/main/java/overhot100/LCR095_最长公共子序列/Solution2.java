package overhot100.LCR095_最长公共子序列;

/*
如果需要空间优化（O(min(m,n))），可以用这个版本，但输出子序列必须用二维 DP 回溯，一维无法直接还原
空间优化版（一维 DP）
 */
public class Solution2 {
    // 一维 DP 求长度（空间优化）
    public int longestCommonSubsequenceOpt(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) return longestCommonSubsequenceOpt(text2, text1);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int left = dp[0];
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[j] = left + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                left = temp;
            }
        }
        return dp[n];
    }
}
