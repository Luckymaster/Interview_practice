class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        if(nums.length == 1) return 0;
        if(nums.length == 2) {
            if(nums[0] > nums[1]) return 0;
            else return 1;
        }
        l = getpeek(nums);
            if(l == nums.length - 2){
                if(nums[l + 1] > nums[l]) l +=1;
            }
        return l;
    }
    
    boolean isGreater(int [] nums, int mid){
        if(mid == 0 && nums[mid] > nums[mid+1]) return true;
        if(mid == nums.length-1 && nums[mid] > nums[mid-1]) return true;
        if(mid < 0 || mid > nums.length -1) return false;
        if(mid > 0 && nums[mid] > nums[mid-1]) return true;
        return false;
        
    }
    int getpeek(int [] nums){
        int l = 0;
        int ans = 0;
        int h = nums.length-1;
        int mid = 0;
        while(l < h){
            mid = (l + h)/2;
            if(isGreater(nums,mid)){
                ans = mid;         
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        return ans;
    }
}
