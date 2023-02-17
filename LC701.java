// 701. Insert into a Binary Search Tree

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
    TreeNode insertNode, curr;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insertNode = new TreeNode(val);
        if (root == null)
            return insertNode;
        insert(root);
        return root;
    }

    public TreeNode insert(TreeNode node) {
        if (insertNode == null)
            return null;

        if (node == null) {
            curr = insertNode;
            insertNode = null;
            return curr;
        }

        if (insertNode.val > node.val) {
            node.right = insert(node.right);
        } else {
            node.left = insert(node.left);
        }

        return node;

    }
}