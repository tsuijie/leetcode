
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
        TreeNode tn5 = new TreeNode(11);
        tn5.left = new TreeNode(7);
        tn5.right = new TreeNode(2);
        TreeNode tn7 = new TreeNode(4);
        tn7.left = new TreeNode(5);
        tn7.right = new TreeNode(1);
        TreeNode tn8 = new TreeNode(4);
        tn8.left = tn7;
        TreeNode tn9 = new TreeNode(8);
        tn9.left = new TreeNode(13);
        tn9.right = tn7;
        TreeNode root = new TreeNode(5);
        root.left = tn8;
        root.right = tn9;
        Solution solution = new PathSumIi().new Solution();
        List<List<Integer>> res = solution.pathSum(root, 22);
        System.out.println(res);
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

        // private LinkedList<TreeNode> nodes = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            backtrace(root, sum, new LinkedList<>());
            return this.list;
        }

        private void backtrace(TreeNode node, int sum, LinkedList<Integer> path) {
            if (node == null) return;
            path.addLast(node.val);
            int d = sum - node.val;
            // must be root-to-leaf
            if (d == 0 && node.left == null && node.right == null) {
                // must clone a copy
                this.list.add(new ArrayList<>(path));
                path.removeLast();
                return;
            }
            if (node.left != null) {
                backtrace(node.left, d, path);
            }
            if (node.right != null) {
                backtrace(node.right, d, path);
            }
            path.removeLast();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}