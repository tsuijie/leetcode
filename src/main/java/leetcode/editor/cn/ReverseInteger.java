
//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows.

package leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 1463847412;
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int y = 0;
            while (x != 0) {
                // we don't need to worry about residual because it will not surpass 1
                if (y > 214748364 || y < -214748364) {
                    return 0;
                }
                y = y * 10 + x % 10;
                x = x / 10;
            }
            return y;
//            String str = Integer.toString(x);
//            boolean isNegative = false;
//            StringBuilder reverse = new StringBuilder();
//            for (int i = str.length() - 1; i >= 0; i --) {
//                String c = str.substring(i, i + 1);
//                if (c.equals("-")) {
//                    isNegative = true;
//                    continue;
//                }
//                reverse.append(c);
//            }
//            try {
//                int ret = Integer.parseInt(reverse.toString());
//                if (isNegative) ret = -ret;
//                return ret;
//            } catch (Exception e) {
//                return 0;
//            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}