package leetcoder.sch.Arrays;

public class RemoveElement {
	/*
	 * URL: https://leetcode.com/problems/remove-element/
	 * Result: Accepted
	 * Time: O(n), Memory: O(1)
	 * Explain:
	 * 		We define two pointers, 'start' for current element,
	 * 	'end' for end of array.
	 * 		We move 'start' until across 'end'. In the process,
	 * 	if 'nums[start]' equals 'val', we just need to move 'end'
	 * 	element to replace 'nums[start]' and shrink 'end', or we
	 * 	move 'start' forward.
	 */
	public static int removeElement( int[] nums, int val ) {
		int start = 0, end = nums.length-1;
		while( start <= end ) {
			if( nums[start] == val ) {
				nums[start] = nums[end--];
			} else {
				++start;
			}
		}
		return end+1;
	}
}
