/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1

*/
class SolutionReverseInteger {
    public int reverse(int x) {
        
        int aux = x < 0? x * -1 : x;
        
        int revNum = 0;
        int max = Integer.MAX_VALUE;
        while(aux > 0){
            int last = aux%10;
            int checkOverFlow = (last == 0?10:10);
            if(max / checkOverFlow <= revNum - last) return 0;
            revNum = revNum * 10 + last;
            aux/=10;
        }
        return x < 0? revNum * -1 : revNum;
    }
}
