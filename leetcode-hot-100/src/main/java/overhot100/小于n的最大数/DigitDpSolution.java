package overhot100.小于n的最大数;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026-04-24 21:49
 */
/*
数位 DP 版本（进阶解法）
核心逻辑：用数位 DP 遍历所有合法数，同时记录最大值。
 */
import java.util.*;

public class DigitDpSolution {
    private String R;
    private List<Integer> digits;
    private int len;
    private String tmp;
    private String res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入格式：
        // 第一行：digits的数量
        // 第二行：digits数组（空格分隔）
        // 第三行：整数n
        int m = sc.nextInt();
        int[] digitsArr = new int[m];
        for (int i = 0; i < m; i++) {
            digitsArr[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        DigitDpSolution sol = new DigitDpSolution();
        System.out.println(sol.maxNumber(digitsArr, n));
    }

    public String maxNumber(int[] digitsArr, int n) {
        this.R = String.valueOf(n);
        this.len = R.length();
        this.digits = new ArrayList<>();
        for (int d : digitsArr) {
            this.digits.add(d);
        }
        // 降序排序，优先选大数字
        Collections.sort(this.digits, Collections.reverseOrder());
        this.tmp = "";
        this.res = "";

        // 第一步：构造和n同长度的数
        dfs(0, true, true);

        // 第二步：构造len-1位的数（一定合法，且是该长度的最大值）
        if (len > 1) {
            char maxDigit = (char) (digits.get(0) + '0');
            String shorter = String.valueOf(maxDigit).repeat(len - 1);
            if (res.isEmpty() || shorter.compareTo(res) > 0) {
                res = shorter;
            }
        }

        return res.isEmpty() ? "" : res;
    }

    /**
     * @param i 当前处理到第几位
     * @param isHigh 是否受上界限制（前面和n的高位完全相等）
     * @param isZero 是否全为0（前导零）
     */
    private void dfs(int i, boolean isHigh, boolean isZero) {
        if (i == len) {
            // 递归到最后一位，且不是全零，才更新结果
            if (!isZero) {
                if (res.isEmpty()) {
                    res = tmp;
                }
            }
            return;
        }

        int upper = isHigh ? R.charAt(i) - '0' : 9;
        for (int d : digits) {
            if (d > upper) continue;

            // 处理前导零
            if (isZero && d == 0) {
                dfs(i + 1, false, true);
                continue;
            }

            // 选当前数字，继续递归
            tmp += (char) (d + '0');
            dfs(i + 1, isHigh && (d == upper), false);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }
}
/*
4
1 3 5 7
100

77
 */