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
    public String tree2str(TreeNode root) {
        if(root == null) return null;

        StringBuilder str = new StringBuilder();

        str.append(root.val);

        String left = tree2str(root.left);
        if(left != null) str.append('(').append(left).append(')');

        String right = tree2str(root.right);
        if(right != null) {
          if(left == null) str.append("()");
          str.append('(').append(right).append(')');
        }


        return str.toString();
    }
}