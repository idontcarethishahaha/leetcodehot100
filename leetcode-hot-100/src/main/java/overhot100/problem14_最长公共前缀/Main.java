package overhot100.problem14_最长公共前缀;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026-05-05 18:25
 */
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String[] strs = new String[n];
//        for (int i = 0; i < n; i++) {
//            strs[i] = sc.nextLine().trim();
//        }
//        System.out.println(longestCommonPrefix(strs));
//        sc.close();
//    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // 以第一个字符串为基准
        String base = strs[0];
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            // 逐个比对其他字符串
            for (int j = 1; j < strs.length; j++) {
                // 长度不够 或 字符不相等 → 截断返回
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return base.substring(0, i);
                }
            }
        }
        return base;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
/*
核心思路
以第一个字符串当作参照前缀
逐字符遍历
只要有一个字符串字符对不上 / 长度不足，立刻截取前面返回
全部匹配完，返回第一个串本身
 */
