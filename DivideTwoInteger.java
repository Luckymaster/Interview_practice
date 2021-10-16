/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Example 3:

Input: dividend = 0, divisor = 1
Output: 0
Example 4:

Input: dividend = 1, divisor = 1
Output: 1
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
*/

class DivideTwoInteger {
	public static int divide(int dividend, int divisor) {

		int dn = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE
				: dividend < 0 ? -dividend : dividend;
		int dr = divisor == Integer.MIN_VALUE? Integer.MAX_VALUE: divisor < 0 ? 0-divisor : divisor;
		int dr2 = dr;
		int x = 1;
		int ans = 0;
		int ans1 = 0;
		int y = 0;
		boolean isElse = false;
		boolean isIf = false;
		if (divisor == -1) {

			if (Integer.MAX_VALUE == dividend)
				return -dividend;
			return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : dividend < 0 ? -dividend : -dividend;
		}
		if (divisor == 1) {
			return dividend;
		}
        if(dividend == Integer.MAX_VALUE && divisor==Integer.MIN_VALUE) return 0;

		if (dn < dr)
			return 0;
		while (dn - ans > 0) {
			if (dn - ans > dr + dr && !(ans > Integer.MAX_VALUE - dr)) {
				x += x;
				dr += dr;
				if (isElse) {
					ans += dr;
					y += x;
				} else {
					ans = dr;
					y = x;
					isIf = true;
				}

			} else {
				if (isIf) {
					y = x + 1;
					x = 1;
				} else
					y += 1;
				x = 1;
				dr = dr2;
				ans += dr2;
				isElse = true;
				isIf = false;
			}
		}
		if (dividend == Integer.MIN_VALUE) {
			return ans == Integer.MIN_VALUE && divisor < 0 ? y
					: ans < 0 && divisor < 0 ? y - 1
							: divisor > 0 && ans == Integer.MIN_VALUE ? -y : divisor > 0 ? -y + 1 : y;
		}
		if (dividend == Integer.MAX_VALUE) {
			return ans == Integer.MIN_VALUE && divisor < 0 ? -(y - 1)
					: divisor > 0 && ans == Integer.MIN_VALUE ? y - 1
							: ans < 0 && divisor < 0 ? -(y - 1) : ans < 0 && divisor > 0 ? y - 1 : y;
		}
		if (dividend < 0 && divisor < 0)
			return ans > dn ? y - 1 : ans < 0?y-1: y;
		if (dividend < 0 || divisor < 0)
			return ans == dividend  ? -y : ans == Math.abs(dividend) ? -y:-(y - 1);
		return ans > dn || ans == Integer.MIN_VALUE ? y - 1 : ans < 0 ? y-1:y;
	}
}
