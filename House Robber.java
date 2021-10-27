class Solution {
    
    int [] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return getMaxAmount(0,nums);
    }
    
    int getMaxAmount(int n, int[] nums){
        if(n > nums.length-1) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = Math.max( nums[n] + getMaxAmount(n + 2, nums), getMaxAmount(n+1,nums));
    }
}
