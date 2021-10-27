    class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        if(arr.length == 1) return 0;
        if(arr.length == 2) {
            if(arr[0] > arr[1]) return 0;
            else return 1;
        }
        l = getpeek(arr);
            if(l == arr.length - 2){
                if(arr[l + 1] > arr[l]) l +=1;
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
