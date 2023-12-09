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
    List<Integer> out = new ArrayList(150);
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return out;
    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        out.add(node.val);
        dfs(node.right);
    }
}