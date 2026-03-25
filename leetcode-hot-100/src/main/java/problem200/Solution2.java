package problem200;

import java.util.LinkedList;
import java.util.Queue;

//解法二，bfs广度优先搜索
public class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // 上下左右

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j] = '0'; // 入队即标记
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir : dirs) {
                            int x = curr[0] + dir[0];
                            int y = curr[1] + dir[1];
                            if (x >=0 && x < row && y >=0 && y < col && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                q.offer(new int[]{x,y});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
