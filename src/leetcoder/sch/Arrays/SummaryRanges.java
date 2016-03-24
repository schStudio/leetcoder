package leetcoder.sch.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	/*
	 * URL: https://leetcode.com/problems/summary-ranges/
	 * Result: Accepted
	 * Time: O(n), Memory: O(1) except result for return
	 * Explain:
	 * 		We have two pointers, 'i' for start point of range, 'j' for 
	 * 	end point of range. We move 'j' one step forward until 'nums[j]'
	 * 	is not successive(i.e. nums[j]-nums[j-1] != 1), and we add current
	 * 	range to result(call addRange method). Finally we set start point
	 * 	'i' to 'j' and start the process again. 		
	 */
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if( nums.length == 0 ) {
            return res;
        }
        
        int i = 0, j = 1;
        while( j < nums.length ) {
            if( nums[j] - nums[j-1] != 1 ) {
                addRange( res, nums, i, j );
                i = j;
            }
            ++j;
        }
        addRange( res, nums, i, j );
        return res;
    }
    private static void addRange( List<String> res, int[] nums, int i, int j ) {
        if( nums[i] == nums[j-1] ) {
            res.add( Integer.toString(nums[i]) );
        } else {
            res.add( nums[i]+"->"+nums[j-1] );
        }
    }
}
