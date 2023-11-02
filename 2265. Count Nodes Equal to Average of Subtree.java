public /**
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
   int ans = 0;
   public int averageOfSubtree(TreeNode root) {
       postDfs(root);
       return ans;
   }

   private int[] postDfs(TreeNode node) {
       if(node == null) return new int[]{0, 0};
       int[] left = postDfs(node.left);
       int[] right = postDfs(node.right);
       int total = node.val+left[0]+right[0];
       int noOfNodes = 1 + left[1] + right[1];
       if(total/noOfNodes == node.val)ans++;
       return new int[] {total, noOfNodes};
   }
} {
    
}
