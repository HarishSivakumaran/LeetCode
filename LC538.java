// 538. Convert BST to Greater Tree

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
    public TreeNode convertBST(TreeNode root) {
        greaterTree(root, 0);
        return root;
    }

    public int greaterTree(TreeNode node, int greaterPar) {
        if (node == null)
            return greaterPar;
        node.val += greaterTree(node.right, greaterPar);
        if (node.left != null)
            return greaterTree(node.left, node.val);
        return node.val;
    }
}