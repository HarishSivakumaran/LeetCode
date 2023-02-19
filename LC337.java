// 337. House Robber III

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
    public int rob(TreeNode root) {
        return robMax(root, new HashMap());
    }

    public int robMax(TreeNode node, HashMap<TreeNode, Integer> hm) {
        if (node == null)
            return 0;
        if (hm.containsKey(node))
            return hm.get(node);

        int ans = 0;

        if (node.left != null)
            ans += (robMax(node.left.left, hm) + robMax(node.left.right, hm));
        if (node.right != null)
            ans += (robMax(node.right.left, hm) + robMax(node.right.right, hm));

        ans = Math.max(ans + node.val, (robMax(node.left, hm) + robMax(node.right, hm)));
        hm.put(node, ans);
        return ans;
    }
}