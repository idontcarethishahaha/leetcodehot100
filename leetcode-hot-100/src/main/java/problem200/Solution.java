package problem200;

//解法一，dfs深度优先搜索
class Solution {
    void dfs(char grid[][],int m,int n){
        int r=grid.length;//行数
        int c=grid[0].length;//列数

        //递归终止条件：越界 或 当前为水域
        if(m<0||m>=r||n<0||n>=c||grid[m][n]=='0') return;

        grid[m][n]='0';//已被访问过的陆地改成水域

        //遍历4个方向
        dfs(grid,m-1,n);//上
        dfs(grid,m+1,n);//下
        dfs(grid,m,n-1);//左
        dfs(grid,m,n+1);//右
    }
    public int numIslands(char[][] grid) {
       int r=grid.length;//行
       int c=grid[0].length;//列

       int cnt=0;//计数

       //边界处理，空网格返回0
       if(r==0||grid==null) return 0;

       //遍历网格
       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               //未被访问的陆地，岛屿数加一，使用dfs标记联通区域
               if(grid[i][j]=='1'){
                   cnt++;
                   dfs(grid,i,j);
               }
           }
       }
       return cnt;
    }
}
