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
    List<Integer> out = new ArrayList();
    List<TreeNode> nodes = new ArrayList();
    int level = 0;
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        int l = level++;

        recoverTree(root.left);

        out.add(root.val);
        nodes.add(root);

        recoverTree(root.right);

        if(l == 0){
            Collections.sort(out);
            for(int i = 0; i < out.size(); i++) {
                nodes.get(i).val = out.get(i);
            }
        }

    }
}