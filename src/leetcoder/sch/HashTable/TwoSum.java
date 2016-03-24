package leetcoder.sch.HashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/*
	 * URL: https://leetcode.com/problems/two-sum/
	 * Result: Accepted
	 * Time: O(n), Memory: O(n)
	 * Explain:
	 * 		We build a hashtable to store previous numbers, for current
	 * 	number, we only need to check if (target-currentNumber) exists
	 * 	in hashtable, if it is, we found, if not, we move to next number
	 */
	public static int[] twoSum( int[] nums, int target ) {
		Map<Integer, Integer> hash = new HashMap<>();
		for( int i = 0; i < nums.length; ++i ) {
			if( hash.containsKey(target-nums[i]) ) {
				return new int[]{ hash.get(target-nums[i]), i };
			} else {
				hash.put( nums[i], i );
			}
		}
		return null;
	}
}
