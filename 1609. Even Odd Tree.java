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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null || ((root.val&1) != 1)) return false;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int l = 1;
        while(q.size() > 0) {
            int len = q.size();
            Integer prev = null;
            for(int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(((l&1) == 1) && (((node.val&1) != 1) || (prev != null && node.val <= prev))) { //odd
                    return false;
                } 

                if(((l&1) != 1) && (((node.val&1) == 1) || (prev != null && node.val >= prev))){ //even
                    return false;
                }

                prev = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            l++;
        }

        return true;
    }
}