/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

*/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int idx = upperBound(nums,target);
        //System.out.println("idx = " + idx);
        if(idx == 0 && nums[idx] > target) return idx;
        if(idx == 0 && nums[idx] < target) return idx+1;
        if(idx==nums.length-1 && nums[idx]>target) return idx;
        if(idx==nums.length-1 && nums[idx]<target) return idx+1;
        if(nums[idx] == target) return idx;
        return idx;
    }
    
    int upperBound(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        int mid = 0;
        int ans = 0;
        while(l < h){
             mid = (l + h)/2;
            if(target == nums[mid]) return mid;
            if(target >= nums[mid]){
                l = mid + 1;
                ans = mid;
            }else{
                h = mid;
            }
        }
        return l;
    }    
}
