package problem238_除了自身以外数组的乘积;

import java.util.Arrays;

// 双指针
class Solution {
    //维护两个变量，beforeSum表示前缀和，afterSum表示后缀和
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        int beforeSum=1;
        int afterSum=1;
        for(int i=0,j=n-1;i<n;i++,j--){
            ans[i]*=beforeSum;
            ans[j]*=afterSum;
            beforeSum*=nums[i];
            afterSum*=nums[j];
        }
        return ans;
    }
}
