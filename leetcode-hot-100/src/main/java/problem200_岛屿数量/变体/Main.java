package problem200_岛屿数量.变体;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    // DFS返回当前岛屿的面积
    int dfs(char[][] grid, int m, int n) {
        int r = grid.length, c = grid[0].length;
        if (m < 0 || m >= r || n < 0 || n >= c || grid[m][n] == '0') {
            return 0;
        }
        grid[m][n] = '0';
        int area = 1;
        area += dfs(grid, m + 1, n); // 下
        area += dfs(grid, m - 1, n); // 上
        area += dfs(grid, m, n - 1); // 左
        area += dfs(grid, m, n + 1); // 右
        return area;
    }

    // 返回所有岛屿的面积列表
    public List<Integer> getAreas(char[][] grid) {
        List<Integer> areas = new ArrayList<>();
        int r = grid.length;
        if (r == 0 || grid == null) return areas;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    areas.add(dfs(grid, i, j));
                }
            }
        }
        return areas;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        Solution sol = new Solution();
        List<Integer> areas = sol.getAreas(grid);

        System.out.println("岛屿数量：" + areas.size());
        System.out.println("每个岛屿的面积：" + areas);
        int total = 0;
        for (int a : areas) total += a;
        System.out.println("陆地总面积：" + total);

        sc.close();
    }
}
/*
4 5
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1

岛屿数量：3
每个岛屿的面积：[4, 1, 2]
陆地总面积：7
 */

/*
3 5
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0

岛屿数量：1
每个岛屿的面积：[8]
陆地总面积：8
 */