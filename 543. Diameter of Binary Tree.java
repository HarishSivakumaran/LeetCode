/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMax(root);
        return ans-1;
    }

    private int getMax(TreeNode root) {
        if(root == null) return 0;

        int l = getMax(root.left), r = getMax(root.right);
        ans = Math.max(ans, 1+l+r);
        return 1 + Math.max(l, r);
    }
}