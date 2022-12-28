// 124. Binary Tree Maximum Path Sum

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
    private int res = Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        maxValPath(root);
        return res;
        
    }

    public int maxValPath(TreeNode node){
        if(node == null) return 0;
        int l = maxValPath(node.left);
        int r = maxValPath(node.right);
        res = Math.max(res,  Math.max(node.val,Math.max(Math.max(l+node.val, r+node.val),l+node.val+r)));
        return Math.max(node.val, Math.max(node.val+l, node.val+r));
    }
}