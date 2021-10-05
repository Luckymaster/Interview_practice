/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

class Solution {
	int[] rightMax;

	public int trap(int[] height) {

		rightMax = new int[height.length];
		rightMax[height.length - 1] = height[height.length - 1];
		int maxh = -1;
		for (int i = height.length -2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], height[i]);
		}
		return getTotalTrapedWater(height, 0, height.length, 0);

	}

	int getTotalTrapedWater(int[] height, int begin, int end, int totelWater) {
		Stack<Integer> st = new Stack<>();
		st.add(begin);
		totelWater = 0;
		int aux = 0;
		for (int i = begin + 1; i < end; i++) {
			if (height[st.peek()] <= height[i]) {
				int start = st.pop();
				st.push(i);
				totelWater += (((i - start - 1) * height[start]) - aux);
				aux = 0;
			} else {
				aux += height[i];
			}
		}
		if (st.peek() < height.length - 1) {
			height[st.peek()] = rightMax[st.peek() + 1];
			return totelWater + getTotalTrapedWater(height, st.peek(), height.length, totelWater);
		}
		return totelWater;
	}
}
