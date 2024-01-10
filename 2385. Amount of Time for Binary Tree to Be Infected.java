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
    HashMap<TreeNode, TreeNode> parent = new HashMap();
    TreeNode startNode;
    int start;
    public int amountOfTime(TreeNode root, int start) {
        this.start = start;
        fillParent(root, null);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int time = -1;

        while(q.size() > 0) {
            int len = q.size();
            time++;

            while(len > 0) {
                TreeNode curr = q.poll();
                curr.val = -1;

                if(curr.left != null && curr.left.val != -1) {
                    q.add(curr.left);
                }

                if(curr.right != null && curr.right.val != -1) {
                    q.add(curr.right);
                }

                TreeNode par = parent.get(curr);

                if(par != null && par.val != -1) {
                    q.add(par);
                }
            }
        }

        return time;
    }

    private void fillParent(TreeNode node, TreeNode par) {
        if(node == null) return;
        parent.put(node, par);
        if(node.val == start) startNode = node;
        fillParent(node.left, node);
        fillParent(node.right, node);
    }
}