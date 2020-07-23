
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

package leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int carry = 0;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // create a dummy node
            ListNode dummy = new ListNode(0);
            ListNode chain = dummy;
            while (l1 != null || l2 != null) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                if (sum >= 10) {
                    carry = 1;
                    sum = sum % 10;
                } else {
                    carry = 0;
                }
                chain.next = new ListNode(sum);
                chain = chain.next;
            }
            // leading carry if exists
            if (carry > 0) {
                chain.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}