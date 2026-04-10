package problem221_最大正方形;

/**
 * 类说明：
 *
 * @author WuWenJin
 * @version 1.0
 * @date 2026/4/10 14:09
 */
class Test {
    public int maximalSquare(char[][] matrix) {
       int maxside=0;
       int r=matrix.length;
       int c=matrix[0].length;

       if(matrix==null||r==0||c==0) return 0;

       int[][] dp=new int[r][c];

       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               if(matrix[i][j]=='1'){
                   if(i==0||j==0){
                       dp[i][j]=1;
                   }else{
                       dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                   }
                   maxside=Math.max(maxside,dp[i][j]);
               }
           }
       }
       int res=maxside*maxside;
       return res;
    }
}
