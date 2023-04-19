// 1372. Longest ZigZag Path in a Binary Tree

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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        getMaxZigZag(root.left, true);
        getMaxZigZag(root.right, false);
        return max;
    }

    public int getMaxZigZag(TreeNode node, boolean fromLeft) {
        if (node == null)
            return 0;
        int left = getMaxZigZag(node.left, true);
        int right = getMaxZigZag(node.right, false);
        int b = fromLeft ? right++ : left++;

        max = Math.max(max, Math.max(left, right));

        return fromLeft ? right : left;
    }
}