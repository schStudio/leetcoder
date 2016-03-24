package leetcoder.sch.HashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	/*
	 * URL: https://leetcode.com/problems/word-pattern/
	 * Result: Accepted
	 * Time: O(n), Memory: O(n)
	 * Explain:
	 * 		Our goal is to walk through 'pattern' and 'str', if we can walk
	 * 	to the end of 'pattern' and 'str', we can assure the pattern is true,
	 * 	if we can't make it, the pattern is false.
	 * 		We know that character and word is an one-to-one relationship,
	 * 	So we need two hashtables to retain this relationship. Each time
	 * 	we extract a character 'ch' and a word 'word', and then check whether
	 * 	their relationship is correct, if correct we step into next round, or
	 * 	we break out.
	 * 		algorithm of checking one-to-one relationship: if there exists
	 * 	relationship between 'ch' and 'word', we check both 'ch'->'word' and
	 * 	'word'->'ch'. If one of these two conditions failed, we break out. 
	 */
	public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> hash1 = new HashMap<>();
        Map<String, Character> hash2 = new HashMap<>();
        int patIndex = 0;
        int strLen = 0;
        for( patIndex = 0; patIndex < pattern.length() && strLen < str.length(); ++patIndex ) {
            char ch = pattern.charAt( patIndex );
            String word = parseWord( str, patIndex+strLen );
            strLen += word.length();
            if( hash1.containsKey(ch) && !hash1.get(ch).equals(word) ) {
            	break;
            }
            if( hash2.containsKey(word) && hash2.get(word) != ch ) {
            	break;
            }
            if( !hash1.containsKey(ch) ) {
            	hash1.put( ch, word );
            	hash2.put( word, ch );
            }
        }
        return patIndex==pattern.length()&&strLen+patIndex-1==str.length();
	}
	public static String parseWord( String str, int start ) {
		int end = start;
		while( end < str.length() && str.charAt(end) != ' ' ) {
			++end;
		}
		return str.substring(start, end);
	}
	
	public static void main( String[] args ) {
		String pattern = "abba";
		String str = "cat cat cat cat";
		System.out.println( wordPattern( pattern, str ) );
	}
}
