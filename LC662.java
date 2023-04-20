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
    long max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        List<Long> val = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        val.add(1l);
        root.val = val.size()-1;
        long min = 10000, maxVal = -10;

        while(q.size() > 0){
            int len = q.size();
            min = Long.MAX_VALUE; maxVal = Long.MIN_VALUE;
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                long value = val.get(curr.val);
                min = Math.min(min, value);
                maxVal = Math.max(maxVal, value);

                if(curr.left != null){
                    val.add((long)((2*value)-1));
                    curr.left.val = val.size()-1;
                    q.add(curr.left);
                }

                if(curr.right != null){
                    val.add((long)(2*value));
                    curr.right.val = val.size()-1;
                    q.add(curr.right);
                }

                max = Math.max(maxVal-min+1, max);
            }

        }

        return (int)max;

    }
}