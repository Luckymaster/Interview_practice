class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n +1];
        Arrays.fill(dp,0);
        return climb(n,dp);
    }
    
    int climb(int n, int [] dp){
        
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 3;
        
        if(dp[n]!=0) {
            return dp[n];
        }
        
        dp[n]  = climb(n - 1, dp) + climb(n - 2, dp);
        
        return dp[n];
    }
}
