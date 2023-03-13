// 101. Symmetric Tree

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
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root, root);
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null || node1.val != node2.val)
            return false;

        return isSameTree(node1.right, node2.left) && isSameTree(node1.left, node2.right);
    }

    public TreeNode invert(TreeNode node) {
        if (node == null)
            return null;
        TreeNode curr = new TreeNode(node.val);
        TreeNode temp = node.left;
        curr.left = invert(node.right);
        curr.right = invert(temp);
        return curr;
    }
}