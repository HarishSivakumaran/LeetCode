// 230. Kth Smallest Element in a BST


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
    public int kthSmallest(TreeNode root, int k) {
             PriorityQueue<Integer> pq
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
                dfs(root, pq,k);
                return pq.peek();

        
    }

    void dfs(TreeNode node,  PriorityQueue<Integer> pq, int k){
        if(node == null) return;

        if(pq.size() < k){
            pq.add(node.val);
        }else if(pq.peek() > node.val){
            pq.poll();
            pq.add(node.val);
        }

        dfs(node.left, pq, k);
        dfs(node.right, pq, k);


    }
}