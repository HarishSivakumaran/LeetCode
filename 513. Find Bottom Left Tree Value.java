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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int l = -1;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                if(i == 0) l = q.peek().val;
                TreeNode node = q.poll();
                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }
        }

        return l;
    }
}