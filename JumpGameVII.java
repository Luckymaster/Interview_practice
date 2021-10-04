/*
You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.

 

Example 1:

Input: s = "011010", minJump = 2, maxJump = 3
Output: true
Explanation:
In the first step, move from index 0 to index 3. 
In the second step, move from index 3 to index 5.
Example 2:

Input: s = "01101110", minJump = 2, maxJump = 3
Output: false
 

Constraints:

2 <= s.length <= 105
s[i] is either '0' or '1'.
s[0] == '0'
1 <= minJump <= maxJump < s.length
*/
class JumpGameVII {
	public boolean canReach(String s, int minJump, int maxJump) {
		return canReachToEnd(s, minJump, maxJump, 0, maxJump) || canReachToEnd(s, minJump, maxJump, 0, minJump);

	}

	public boolean canReachToEnd(String s, int minJump, int maxJump, int i, int j) {
		if (j < 0)
			return false;
		if (s.charAt(j) == '0') {
			i = j;
			if (j >= s.length() - 1)
				return true;
		}
		return canReachToEnd(s, minJump, maxJump, i, getNextZerothIndex(s, i, minJump, maxJump));

	}

	int getNextZerothIndex(String s, int start, int minJump, int maxJump) {
		int maxIndex = -1;
		int MIN = Math.min(maxJump + start, s.length() - 1);
		if (MIN < start + minJump && (start + minJump - MIN) == (maxJump - minJump) && s.length() == start + minJump) {
			if (s.charAt(MIN) == '0')
				return MIN;
		}
		for (int i = start + minJump; i <= MIN; i++) {
			if (s.charAt(i) == '0' && maxIndex <= i) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
