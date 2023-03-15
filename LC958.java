// 958. Check Completeness of a Binary Tree
// // 

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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        boolean reachedNull = false;
        TreeNode curr = null;
        q.add(root);
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                curr = q.poll();
                if (curr == null) {
                    reachedNull = true;
                    continue;
                }

                if (reachedNull)
                    return false;

                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return true;

    }
}