package leetcoder.sch.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicated2 {
	/*
	 * First version: force method
	 * Result: TLE
	 * Time: O(n*k), Memory: O(1)
	 * Explain:
	 * 		first phase, we search [0,k] elements
	 * 		second phase, we search [k+1, nums.length] elements
	 * 		we split it to two phases, because we use different algorithm to search
	 * 		for first phase, we just need to move 'j' one step forward
	 * 		for second phase, we need to move both 'i' and 'j' one step forward
	 */
	public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        // first phase: search [0, k]
        int i = 0, j = 1;
        while( j < nums.length && j-i <= k ) {
        	for( int x = i; x < j; ++x ) {
        		if( nums[x] == nums[j] ) return true;
        	}
            ++j;
        }
        // second phase: search [k+1, nums.length]
        while( j < nums.length ) {
            for( int x = i+1; x < j; ++x ) {
                if( nums[x] == nums[j] ) return true;
            }
            ++i;
            ++j;
        }
        return false;
    }
	
	/*
	 * First version: using HashSet
	 * Result: Accepted
	 * Time: O(n), Memory: O(k)
	 * Explain:
	 * 		first, we create a empty HashSet
	 * 		second, for every elements we search HashSet to see whether there
	 * 		exists duplicated numbers, if exists, we found duplicated numbers,
	 * 		if not exists, we need to check whether HashSet is full of k numbers
	 * 		if it is not full, we only need to add current element to HashSet
	 * 		if it is full, we add current element and remove the one k step before
	 */
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>(k+1);
        
        for( int i = 0; i < nums.length; ++i ) {
        	if( set.contains(nums[i]) ) {
        		return true;
        	} else if( set.size() < k ) {
        		set.add( nums[i] );
        	} else {
        		set.add( nums[i] );
        		set.remove( nums[i-k] );
        	}
        }
        return false;
    } 
	
	public static void main( String[] args ) {
		// true test:
		int[] nums0 = {1,1};
		int[] nums1 = {1,2,3,4,1};
		int k0 = 1;
		int k1 = 4;
		// false test:
		int[] nums2 = {};
		int[] nums3 = {1};
		int[] nums4 = {1,2,1};
		int k2 = 1;
		int k3 = 1;
		int k4 = 1;
		
		System.out.println( containsNearbyDuplicate2(nums0, k0) );
		System.out.println( containsNearbyDuplicate2(nums1, k1) );
		System.out.println( containsNearbyDuplicate2(nums2, k2) );
		System.out.println( containsNearbyDuplicate2(nums3, k3) );
		System.out.println( containsNearbyDuplicate2(nums4, k4) );
	}
}
