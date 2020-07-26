
//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String test = "abba";
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            int start = 0;
            int end = 0;
            int maxLen = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i ++) {
                end = i;
                Character c = s.charAt(i);
                Integer collision = map.get(c);
                if (collision != null && collision >= start) {
                    start = collision + 1;
                }
                int newLen = end - start + 1;
                if (newLen > maxLen) maxLen = newLen;
                map.put(c, i);
            }
            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}