// 687. Longest Univalue Path
// // 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxPathFinal = 0;

    public int longestUnivaluePath(TreeNode root) {
        traverse(root, -2000);
        return maxPathFinal;
    }

    public int traverse(TreeNode node, int prev) {
        if (node == null)
            return 0;

        int maxPathLeft = traverse(node.left, node.val);
        int maxPathRight = traverse(node.right, node.val);
        maxPathFinal = Math.max(maxPathFinal, maxPathLeft + maxPathRight);

        return node.val == prev ? 1 + Math.max(maxPathLeft, maxPathRight) : 0;

    }
}