class Solution {
    Map<Integer,Integer> frq;
    int max = 10001;
    public int deleteAndEarn(int[] nums) {
        frq = new HashMap<>();
        for(int i:nums){
            Integer aux = frq.get(i);
            if(aux == null){
                frq.put(i,1);
            }else{
                frq.put(i,aux + 1);
            }
        }
        int [] dp = new int[max + 2];
        Arrays.fill(dp,0);
        if(nums.length == 1) return nums[0];
        int take = 0;
        int dont_take = 0;
        for(int i=2;i<max;i++){
            if(frq.get(i-1)!= null){
                take =  frq.get(i-1) * (i-1) + dp[i-2];
                dont_take = dp[i-1];
                dp[i] = Math.max(take,dont_take);
                //System.out.println("dp["+ i + "] = " +dp[i]);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[max-1];
    } 
}
