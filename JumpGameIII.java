/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length
*/

class SolutionJumpGameIII {
	int[] dp;
	boolean reached = false;

	public boolean canReach(int[] arr, int start) {
		dp = new int[arr.length];
		int[] isVisited = new int[arr.length];
		Arrays.fill(dp, -1);
		Arrays.fill(isVisited, 0);
		canReachZero(arr, start, isVisited);
		return reached;

	}

	private int canReachZero(int[] arr, int start, int[] isVisited) {

		if (start >= 0 && start < arr.length && isVisited[start] != 1) {
			if (start < 0) {
				return -1;
			}
			if (arr[start] == 0) {
				dp[start] = 1;
				reached = true;
				return 1;
			}

			isVisited[start] = 1;
			if (dp[start] != -1)
				return dp[start];
			int isDone = canReachZero(arr, start + arr[start], isVisited);

			if (start + arr[start] < arr.length) {
				dp[start + arr[start]] = isDone;
			}

			int isDone1 = canReachZero(arr, start - arr[start], isVisited);

			if (start - arr[start] >= 0) {
				dp[start - arr[start]] = isDone1;
			}
		}

		return 0;

	}
}
