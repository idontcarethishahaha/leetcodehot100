package problem70_跳楼梯;

// 一维DP,跳楼梯

public class Solution {
    public int climbStairs(int n){
        //只有一阶，只有一种走法
       if(n==1) return 1;
       // dp[i]表示爬到第i阶的方法数
       int[] dp=new int[n+1];

       dp[0]=1;//0阶，1种
       dp[1]=1;//1阶，1种

       for(int i=2;i<=n;i++){
           dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n];
    }
}
