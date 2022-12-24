//  100. Same Tree

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
    public boolean isSameTree(TreeNode p, TreeNode t) {
        if( p == null && t == null){
            return true;
        }else if (p == null || t == null || p.val != t.val){
            return false;
        }
        Queue<TreeNode[]> q = new LinkedList<>();
        q.add(new TreeNode[]{p,t});

        while(q.size()!=0){
            TreeNode[] aT = q.remove();
            // compare
            TreeNode a = aT[0], b = aT[1];

            if( a.left == null && b.left == null){
                //do nothing
            }else if (a.left == null || b.left == null || a.left.val != b.left.val){
                this.res = false;
                break;
            }else if(a.left.val == b.left.val ){
                q.add(new TreeNode[]{a.left, b.left});
            }

            if( a.right == null && b.right == null){
            }else if (a.right == null || b.right == null || a.right.val != b.right.val){
                this.res = false;
                break;
            }else if(a.right.val == b.right.val ){
                q.add(new TreeNode[]{a.right, b.right});
            }

            

        }

        return this.res;
    }

     
    
}