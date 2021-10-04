/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
*/
class SolutionJumpGameII {

	public int jump(int[] nums) {
        int len = nums.length;
		if(len == 1) return 0;
		if(len == 2) return 1;
		return  minJump(nums, 0);
	}

	int minJump(int[] nums, int idx) {

		if (idx >= nums.length || idx == nums.length - 1 )
			return 0;
		return minJump(nums, getNextIndex(idx, nums)) + 1;
	}
    
	int getNextIndex(int idx, int[] nums) {
		int nextIdx = -1;
		int nextMax = -1;
		if (nums[idx] + idx >= nums.length - 1)
			return nums.length - 1;
		for (int i = idx+1; i <= nums[idx] + idx; i++) {
			int aux = nums[i] + i;
			if (nextMax <= aux) {
				nextIdx = i;
				nextMax = aux;
			}
		}
		return nextIdx;
	}
}
