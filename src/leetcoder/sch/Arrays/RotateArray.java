package leetcoder.sch.Arrays;

public class RotateArray {
	/*
	 * URL: https://leetcode.com/problems/rotate-array/
	 * Result: Accepted
	 * Time: O(n), Memory: O(1)
	 * Explain:
	 * 		Suppose we split original array to two parts T and S,
	 * 	so our goal is to make TS turn into ST
	 * 		Now we define: S' is the reversal of S
	 * 		We can know: TS ==> (T'S')' ==> ST
	 */
	public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse( nums, 0, nums.length-1 );
        reverse( nums, 0, k-1 );
        reverse( nums, k, nums.length-1 );
    }
    private static void reverse( int[] nums, int start, int end ) {
        while( start < end ) {
            int cache = nums[start];
            nums[start++] = nums[end];
            nums[end--] = cache;
        }
    }
}
