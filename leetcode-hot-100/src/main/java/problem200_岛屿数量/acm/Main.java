package problem200_岛屿数量.acm;


import java.util.Scanner;
class Solution {
    void dfs(char[][] grid,int m,int n){
        int r=grid.length,c=grid[0].length;
        if(m<0 || m>=r || n<0 || n>=c||grid[m][n]=='0') return;
        grid[m][n]='0';
        dfs(grid,m-1,n);
        dfs(grid,m+1,n);
        dfs(grid,m,n-1);
        dfs(grid,m,n+1);
    }
    public int fun(char[][] grid){
        int r=grid.length,c=grid[0].length;
        int cnt=0;

        if(r==0||grid==null) return 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]=='1') {
                    cnt++;
                    dfs(grid,i,j);
                }

            }
        }
        return cnt;
    }
}

public class Main {


   public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int m,n;
       m = sc.nextInt();
       n = sc.nextInt();
       char[][] grid = new char[m][n];
       // 3. 按行读取，每行转成字符数组
       for (int i = 0; i < m; i++) {
         for(int j=0;j<n;j++){
             grid[i][j] = sc.next().charAt(0);
         }
       }

       Solution sol = new Solution();
       int res=sol.fun(grid);
       System.out.println(res);

       sc.close();
   }
}
