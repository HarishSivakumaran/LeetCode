// 450. Delete Node in a BST

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
    TreeNode prev = null, next = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = findNode(root, key);
        if (node == null)
            return root;
        if (node.left != null && node.right != null) {
            TreeNode right = findNext(node.right);
            if (right != null)
                next.right = right;
            next.left = node.left;
        } else {
            next = node.left == null ? node.right : node.left;
        }
        if (prev == null)
            return next;
        if (key > prev.val) {
            prev.right = next;
        } else {
            prev.left = next;
        }

        return root;
    }

    public TreeNode findNext(TreeNode node) {
        if (node == null)
            return null;
        boolean isNull = node.left == null;
        node.left = findNext(node.left);
        if (isNull && node.left == null) {
            next = node;
            return node.right;
        }

        return node;
    }

    public TreeNode findNode(TreeNode node, int key) {
        if (node == null)
            return null;
        if (node.val == key)
            return node;
        prev = node;
        if (key > node.val) {
            return findNode(node.right, key);
        } else {
            return findNode(node.left, key);
        }
    }
}