/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
*/
class SolutionJumpGame {
	public boolean canJump(int[] nums) {
		return minJumpTolast(nums, 0) == 1 ? true : false;
	}


	int getNextIndex(int idx, int[] nums) {
		int nextIdx = -1;
		int nextMax = -1;
		if (nums[idx] == 0)
			return Integer.MAX_VALUE;
		if (nums[idx] + idx >= nums.length - 1)
			return nums.length - 1;
		for (int i = idx + 1; i <= nums[idx] + idx; i++) {
			int aux = nums[i] + i;
			if (nextMax <= aux) {
				nextIdx = i;
				nextMax = aux;
			}
		}
		return nextIdx;
	}
    
	int minJumpTolast(int[] nums, int idx) {

		if (idx > nums.length || idx < 0)
			return 0;
		if (idx == nums.length - 1)
			return 1;
		return minJumpTolast(nums, getNextIndex(idx, nums));
	}
}
