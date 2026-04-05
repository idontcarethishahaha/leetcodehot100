package problem221_最大正方形;

/*
给你一个由 '0' 和 '1' 组成的二维矩阵问：
里面由 1 组成的最大正方形的面积是多少？
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0; // 记录最大边长
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        //dp[i][j] 表示：以坐标 (i,j) 为右下角的最大正方形的边长
        // 我们最终要找整个矩阵里最大的边长，然后 边长 × 边长 = 答案
        int[][] dp = new int[rows][columns];

        //双层循环遍历每个格子
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 边界情况，第一行第一列的格子最多只能形成边长为1的正方形
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 状态转移方程
                        /*
                        以 (i,j) 为右下角的最大正方形边长 = 它上方、左方、左上方三个位置的最小边长 + 1
                        为什么？
                        要形成正方形，三个方向必须都能形成同样大小的正方形
                        短板效应：只能取最小的那个
                        再加上当前这个格子，边长 +1
                         */
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j],
                                dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        ) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);//更新全局最大边长
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
/*
dp[i][j] = 以当前点为右下角的最大正方形边长
如果当前是 1
在边界 → 边长 1
不在边界 → 边长 = 上、左、左上 最小边长 + 1
最大面积 = 最大边长 × 最大边长
 */
/*
小例子

矩阵：

1 1
1 1
计算 dp[1][1]：
上 = 1
左 = 1
左上 = 1
min(1,1,1) = 1
dp[1][1] = 1 + 1 = 2
✅ 最大边长 = 2
✅ 最大面积 = 4
 */
/*
左上  上
左   当前(i,j)
想让 当前位置 (i,j) 能构成一个更大的正方形，必须保证：
左上角 能构成一个边长为 k 的正方形
上边 能构成一个边长为 k 的正方形
左边 能构成一个边长为 k 的正方形
只有这三个都够大，你才能在它们基础上，多包一圈，把当前点包进去，形成更大的正方形。
1 1 1
1 1 1
1 1 1
dp[2][2]：
上 = 2
左 = 2
左上 = 2
min = 2
dp[2][2] = 2 + 1 = 3
✅ 边长 3

当前格子能构成多大正方形，
看它左上、上边、左边三个里最小的那个，
然后加 1（把自己包进去）。

min (三个)：看你最多能扩多大
+1：把当前这个 1 算进去
 */