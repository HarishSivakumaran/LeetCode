// 105. Construct Binary Tree from Preorder and Inorder Traversal

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
    public HashMap<Integer, Integer> hm = new HashMap<>();
    public int pIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) return null;

        for(int i = 0; i < inorder.length; i++){
            this.hm.put(inorder[i],i);
        }

        return buildTree(preorder, inorder, 0 , inorder.length - 1);
         
    }

    public TreeNode buildTree(int[] preorder ,int[] inorder, int s, int e){
        
        if(s < 0 || s >= inorder.length || e < 0 || e >= inorder.length || this.pIndex >= inorder.length || s > e) return null;
        int curr = preorder[this.pIndex];
        TreeNode node = new TreeNode(preorder[this.pIndex++]);
        int iIndex = this.hm.get(curr);
        node.left = buildTree(preorder, inorder, s , iIndex-1);
        node.right = buildTree(preorder, inorder, iIndex+1 , e);
        return node;


    }
}