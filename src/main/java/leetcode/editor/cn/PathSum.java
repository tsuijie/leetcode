
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
//uch that adding up all the values along the path equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
// 
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

package leetcode.editor.cn;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            int d = sum - root.val;
            if (root.left == null && root.right == null) {
                return d == 0;
            }
            // dfs
            return hasPathSum(root.left, d) || hasPathSum(root.right, d);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}