// 102. Binary Tree Level Order Traversal
// // 

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null) return out;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() != 0){
           int len = q.size();
           List<Integer> a = new ArrayList<Integer>();

           for(int i = 0; i < len ; i++){
              TreeNode node = q.remove(); 
              a.add(node.val);
              if(node.left != null){
                q.add(node.left);
            }

            if(node.right != null){
                q.add(node.right);
            }
           }
           out.add(a);

        }
        return out;

        
    }
}