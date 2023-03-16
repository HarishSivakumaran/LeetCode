// 106. Construct Binary Tree from Inorder and Postorder Traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, map, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> map, int start, int end, int inorderStart,
            int inorderEnd) {
        if (start > end)
            return null;
        TreeNode node = new TreeNode(postorder[end]);
        int m = map.get(postorder[end]);
        int noOfElementsToTheLeft = m - inorderStart;
        node.left = buildTree(postorder, map, start, start + noOfElementsToTheLeft - 1, inorderStart, m - 1);
        node.right = buildTree(postorder, map, start + noOfElementsToTheLeft, end - 1, m + 1, inorderEnd);
        return node;
    }
}