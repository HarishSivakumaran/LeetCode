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
    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] vals = new int[10];
        dfs(root, vals);
        return ans;
    }

    private void dfs(TreeNode node, int[] vals) {
        vals[node.val]++;
        if (node.left == null && node.right == null) {
            int noOdd = 0, total = 0;
            for (int n : vals) {
                if ((n & 1) == 1)
                    noOdd++;
                total += n;
            }

            if (total > 0 && noOdd < 2)
                ans++;
            vals[node.val]--;

            return;
        }
        if (node.left != null)
            dfs(node.left, vals);
        if (node.right != null)

            dfs(node.right, vals);
        vals[node.val]--;
    }
}