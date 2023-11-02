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
    TreeMap<Integer, List<Integer>> freq = new TreeMap();
    int[] curr = {Integer.MIN_VALUE, -1}; //num, count

    public int[] findMode(TreeNode root) {
        dfs(root);
        freq.computeIfAbsent(curr[1], v -> new ArrayList()).add(curr[0]);
        List<Integer> ans = freq.get(freq.lastKey());
        int[] out = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            out[i] = ans.get(i);
        }

        return out;
    }

    private void dfs(TreeNode node) {
        if(node == null) return;

        dfs(node.left);

        if(curr[0] != node.val) {
            freq.computeIfAbsent(curr[1], v -> new ArrayList()).add(curr[0]);
            curr[0] = node.val;
            curr[1] = 1;
        } else {
            curr[1]++;
        }

        dfs(node.right);
    }
}