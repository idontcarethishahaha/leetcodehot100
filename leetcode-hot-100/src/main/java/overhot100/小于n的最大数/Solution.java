package overhot100.小于n的最大数;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026-04-24 21:48
 */
/*
给定一个非递减有序的数字数组 digits（如 ["1","3","5","7"]），每个数字可以用任意次，拼成一个正整数。求所有能拼出且 ≤ n 的正整数中的最大值。
示例：
输入：digits = ["1","3","5","7"], n = 100
输出：77（因为两位数里最大是 77，三位数无法组成≤100 的数）
 */
/*
贪心 + 回溯
核心逻辑：逐位构造，优先对齐 n，不行就回退，后面全补最大值。
 */
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入格式：第一行 digits 的数量，第二行 digits 数组，第三行 n
        int m = sc.nextInt();
        String[] digits = new String[m];
        for (int i = 0; i < m; i++) {
            digits[i] = sc.next();
        }
        int n = sc.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.maxNumber(digits, n));
    }

    public String maxNumber(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        StringBuilder res = new StringBuilder();
        boolean flag = false; // 标记前面是否已经比 n 小了，后面直接补最大值
        int i = 0;

        while (i < len && !flag) {
            char currentN = s.charAt(i);
            char maxEqual = 0;
            char maxLess = 0;

            // 找当前位 <= currentN 的最大数字
            for (String d : digits) {
                char c = d.charAt(0);
                if (c <= currentN) {
                    maxEqual = c;
                }
                if (c < currentN) {
                    maxLess = c;
                }
            }

            // 情况1：能找到等于的数字，继续对齐
            if (maxEqual == currentN) {
                res.append(maxEqual);
                i++;
            }
            // 情况2：只能找到小于的数字，后面直接补最大值
            else if (maxLess != 0) {
                res.append(maxLess);
                flag = true;
                i++;
            }
            // 情况3：找不到 <= currentN 的数字，需要回退
            else {
                // 回退到前一位，把前一位换成更小的数字
                while (i > 0) {
                    i--;
                    char prev = res.charAt(i);
                    res.deleteCharAt(i);
                    // 找比 prev 小的数字
                    char smaller = 0;
                    for (String d : digits) {
                        char c = d.charAt(0);
                        if (c < prev) {
                            smaller = c;
                        }
                    }
                    if (smaller != 0) {
                        res.append(smaller);
                        flag = true;
                        i++;
                        break;
                    }
                }
                // 回退到第0位都不行，说明只能构造 len-1 位的数
                if (i == 0) {
                    // 特殊情况：digits 包含 0 且 len-1=0（如n=1，digits=[0]），返回0？但题目是正整数，返回空？
                    if (len - 1 == 0) {
                        return "";
                    }
                    char maxDigit = digits[digits.length - 1].charAt(0);
                    return String.valueOf(maxDigit).repeat(len - 1);
                }
            }
        }

        // 前面已经比 n 小了，后面全补最大值
        if (flag) {
            char maxDigit = digits[digits.length - 1].charAt(0);
            while (res.length() < len) {
                res.append(maxDigit);
            }
        }

        return res.toString();
    }
}