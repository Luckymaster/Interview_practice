/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


*/

class Solution {


	public static int[] productExceptSelf(int[] nums) {

		int p = nums[nums.length - 1];
		List<Integer> zeros = new ArrayList<>();
		int isZero = 0;
		int negative = 0;
		int[] rprod = new int[nums.length];
		int[] pprodL = new int[nums.length];
		rprod[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] != 0) {
				p *= nums[i];
				rprod[i] = p;
			} else {
				isZero++;
				zeros.add(i);
			}
			if (nums[i] < 0)
				negative++;
		}
		if (isZero == 1) {
			Arrays.fill(nums, 0);
			nums[zeros.get(0)] = p;
			return nums;
		}
		if (isZero > 1) {
			Arrays.fill(nums, 0);
			return nums;
		}
		p = 1;

		for (int i = 0; i < nums.length; i++) {
			p *= nums[i];
			pprodL[i] = p;
		}
		for (int i = 1; i < nums.length - 1; i++) {
			nums[i] = rprod[i + 1] * pprodL[i - 1];
		}
		nums[0] = rprod[1];
		nums[nums.length - 1] = pprodL[nums.length - 2];

		return nums;
	}
}
