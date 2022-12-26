// 98. Validate Binary Search Tree

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
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        dfsSubTree(root);
        return this.res;
                
    }

    int[] dfsSubTree(TreeNode node){
        if(node == null || !this.res) return null;
        int[] minMax = new int[]{node.val, node.val};
        int[] l =null,r = null;

        if(node.left != null){
            if(node.left.val >= node.val) this.res = false;
            l = dfsSubTree(node.left);
        }

        if(l != null ){
            if(l[1] >= node.val ){
             this.res = false;
             return null;
            }
            minMax[0] =Math.min(minMax[0], l[0]);
            minMax[1] =Math.max(minMax[1], l[1]);
        }
         if(node.right != null){
            if(node.right.val <= node.val) this.res = false;
            r = dfsSubTree(node.right);
        }

        if(r != null ){
            if(r[0] <= node.val){
             this.res = false;
             return null;
            }
            minMax[0] =Math.min(minMax[0], r[0]);
            minMax[1] =Math.max(minMax[1], r[1]);
        }

        return minMax;




    }
}