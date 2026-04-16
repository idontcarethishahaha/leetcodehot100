package overhot100.LCR095_最长公共子序列.变体;


//输出具体子序列
import java.util.Scanner;

class Solution {
    // 1. 先构建 DP 数组（和你原来的代码完全一致）
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // 2. 输出具体最长公共子序列的方法
    public String getLCSString(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 第一步：构建 DP 数组（和求长度版完全一致）
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 第二步：反向回溯 DP 数组，还原 LCS
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            char c1 = text1.charAt(i - 1);
            char c2 = text2.charAt(j - 1);
            if (c1 == c2) {
                // 字符相等，属于 LCS，加入结果
                sb.append(c1);
                i--;
                j--;
            } else {
                // 字符不等，向值更大的方向移动
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // 第三步：反转得到正序的 LCS
        return sb.reverse().toString();
    }
}

// ===================== ACM 主程序 =====================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入格式：
        // 第一行：字符串 text1
        // 第二行：字符串 text2
        String text1 = sc.nextLine().trim();
        String text2 = sc.nextLine().trim();

        Solution sol = new Solution();
        // 输出长度
        int len = sol.longestCommonSubsequence(text1, text2);
        System.out.println("最长公共子序列长度：" + len);

        // 输出具体子序列
        String lcs = sol.getLCSString(text1, text2);
        System.out.println("最长公共子序列：" + lcs);

        sc.close();
    }
}
/*
abcde
ace

最长公共子序列长度：3
最长公共子序列：ace
 */
