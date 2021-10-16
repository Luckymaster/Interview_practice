/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int [] res = new int[2];
        if(nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        if(nums.length == 1){
            if(nums[0] == target){
                res[0] = 0;
                res[1] = 0;
                return res;
            }else{
                res[0] = -1;
                res[1] = -1;
                return res;
            }
        }
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        res[0] = lb;
        res[1] =  ub;
        if(lb>=0 && nums[lb] != target){ lb=-1; res[0] = lb;}
        if(ub>=0 && nums[ub] != target){
            if(ub > 0 && nums[ub-1] == target) res[1] = ub - 1;
             else{ub=-1; res[1] = ub;}
        }
        return res;
    }
    
    int lowerBound(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        int mid = 0;
        while(l < h){
            mid = (l + h)/2;
            if(target <= nums[mid]){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return l == nums.length ? -1 : l;
    }
    int upperBound(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        int mid = 0;
        int ans = 0;
        while(l < h){
             mid = (l + h)/2;
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
