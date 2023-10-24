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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValInRow = new ArrayList();
        if(root == null) return maxValInRow;
        Queue<TreeNode> q = new LinkedList();

        q.add(root);
        while(q.size() > 0) {
            int len = q.size();
            int ans = Integer.MIN_VALUE;
            while(len > 0) {
                TreeNode curr = q.poll();
                ans = Math.max(ans, curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                len--;
            }
            maxValInRow.add(ans);
        }

        return maxValInRow;
    }
}