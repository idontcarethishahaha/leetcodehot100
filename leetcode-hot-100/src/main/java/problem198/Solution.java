package problem198;


public class Solution {
    public int rob(int[] nums){
        int n=nums.length;//房间数

        //边界条件，保护代码，用于处理极端的短数组，防止数组越界代码崩溃
        //没有房间时偷不到钱
        if(n==0) return 0;
        //只有一间房时
        if(n==1) return nums[0];


        //dp[i]表示小偷偷到下标为i的房间时可偷取的最大金额
        int[] dp=new int[n];
        //下标从0开始
        //初始化边界
        dp[0]=nums[0];//偷到第一间房
        dp[1]=Math.max(nums[0],nums[1]);//偷到第二间房,不能偷连续的房间，选金额大的
        for(int i=2;i<n;i++){
            //由于不能偷相邻房间，偷第i间就不能偷第i-1间
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];//n-1是最后一间房间的下标，偷到最后一间房的最大金额
    }
}

