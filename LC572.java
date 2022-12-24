// 572. Subtree of Another Tree


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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Queue<TreeNode> q = new LinkedList<>();

        rootSubNodeMatch(root, subRoot.val, q);

        while(q.size()!=0){
            TreeNode a = q.remove();
            boolean res =  DFS(a, subRoot);
            if(res)
              return true;
        } 

        return false;

        
    }

    public void rootSubNodeMatch(TreeNode root, int val, Queue<TreeNode> q){
        if(root == null)
          return;

        if(root.val == val)
          q.add(root);
          

        rootSubNodeMatch(root.left, val, q);
        rootSubNodeMatch(root.right, val, q);

    }

    public boolean DFS(TreeNode l, TreeNode r){
        if(l == null && r == null)
         return true;

         if(l == null || r == null || l.val != r.val)
         return false; 

         boolean left = DFS(l.left, r.left);
         boolean right = DFS(l.right, r.right);

         return left && right;
       

    }
}

class Solution2 {
    public boolean isSubtree(TreeNode r, TreeNode s) {
        if(r == null && s == null){
            return true;
        }

        if(r== null || s == null)
            return false;

        if(DFS_isSameTree(r,s))
          return true;

        return ( isSubtree(r.left,s) || isSubtree(r.right,s)) ;



       
        
    }


    public boolean DFS_isSameTree(TreeNode l, TreeNode r){
        if(l == null && r == null)
         return true;

         if(l == null || r == null || l.val != r.val)
         return false; 

         boolean left = DFS_isSameTree(l.left, r.left);
         boolean right = DFS_isSameTree(l.right, r.right);

         return left && right;
       

    }
}