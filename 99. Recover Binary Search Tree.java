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
    TreeNode firstNode = null, secNode = null, prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        dfs(root);

        int temp = firstNode.val;
        firstNode.val = secNode.val;
        secNode.val = temp;

        // if(l == 0){
        //     long prev = Long.MIN_VALUE, next = Long.MAX_VALUE, curr = 0;
        //     TreeNode biggerThanNeigh = null, smallerThanNeigh = null;
        //     for(int i = 0; i < nodes.size(); i++) {
        //         prev = i-1 >= 0 ? nodes.get(i-1).val : Long.MIN_VALUE;
        //         curr = nodes.get(i).val;
        //         next = i+1 < nodes.size() ? nodes.get(i+1).val : Long.MAX_VALUE;
        //         if(biggerThanNeigh == null && Long.compare(curr, prev) > 0 && Long.compare(curr, next) > 0) 
        //             biggerThanNeigh = nodes.get(i);  
            
        //         if(biggerThanNeigh != null && Long.compare(curr, prev) < 0 && Long.compare(curr, next) < 0) 
        //             smallerThanNeigh = nodes.get(i);  
        //     }

        //     int temp = biggerThanNeigh.val;
        //     biggerThanNeigh.val = smallerThanNeigh.val;
        //     smallerThanNeigh.val = temp;
        // }

    }

    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);

        //logic
        if(firstNode == null && prev.val > node.val) firstNode = prev;
        if(firstNode != null && node.val <= prev.val) secNode = node;
        prev = node;

        dfs(node.right);
    }
}