package leetcoder.sch.Arrays;

public class PlusOne {
	/*
	 * URL: https://leetcode.com/problems/plus-one/
	 * Result: Accepted
	 * Time: O(n), Memory: O(1) or O(n)
	 * Explain:
	 * 		for every element from low to high digit, we add 'carry' to the
	 * 	current 'digit', if current 'digit' is bigger than or equals 10,
	 * 	we need to set next 'carry' to 1; if current 'digit' is less than
	 * 	10, we finish the plus process.
	 * 		finally, we need to check whether 'carry' is 1, if it is, we need
	 * 	to build a new array to store result, or we just return original array.		
	 */
	public static int[] plusOne(int[] digits) {
        int carry = 1;
        // plus process
        for( int i = digits.length-1; i >= 0; --i ) {
            digits[i] += carry;
            carry = 0;
            if( digits[i] >= 10 ) {
                digits[i] -= 10;
                carry = 1;
            } else {
                break;
            }
        }
        if( carry == 0 ) {
            return digits;
        } else {
        	// build a new array
            int[] res = new int[digits.length+1];
            res[0] = carry;
            for( int i = 1; i < digits.length; ++i ) {
                res[i] = digits[i];
            }
            return res;
        }
    }
}
