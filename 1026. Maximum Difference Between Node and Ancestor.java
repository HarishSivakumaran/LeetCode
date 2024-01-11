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
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }

    private void dfs(TreeNode node, int max, int min) {
        if(node == null) return;

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        ans = Math.max(ans, max-min);

        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}