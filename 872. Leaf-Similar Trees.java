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
    List<Integer> l1 = new ArrayList(100);
    List<Integer> l2 = new ArrayList(100);
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, l1);
        dfs(root2, l2);
        if(l1.size() == l2.size()) {
            for(int i =0;i < l1.size(); i++) {
                if(l1.get(i) != l2.get(i)) return false;
            }

            return true;
        }

        return false;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        dfs(node.left, list);
        dfs(node.right, list);
    }
}