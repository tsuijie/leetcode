
//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
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
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
    }
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> list = new ArrayList<>();

        private LinkedList<Integer> path = new LinkedList<>();

        boolean flag = false;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) return list;
            path.add(root.val);
            sum -= root.val;
            // must be root-to-leaf
            if (sum == 0 && root.left == null && root.right == null) {
                list.add(new ArrayList<>(path)); // must clone a copy
                flag = true;
            }
            if (root.left != null) {
                pathSum(root.left, sum);
            }
            if (flag) {
                flag = false;
            } else {
                // if left leaf meet requirement, right leaf can not, this step can be trimmed?
                if (root.right != null) {
                    pathSum(root.right, sum);
                }
            }
            path.remove(path.size() - 1);
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}