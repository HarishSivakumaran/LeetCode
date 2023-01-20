// 173. Binary Search Tree Iterator

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
class BSTIterator {

    List<Integer> inOrder;
    int l = 0;
    public BSTIterator(TreeNode root) {
        inOrder = new ArrayList<>();   
        inorderDFS(root);    
    }

    public void inorderDFS(TreeNode node){
        if(node == null) return;
        this.inorderDFS(node.left);
        inOrder.add(node.val);
        this.inorderDFS(node.right);
    }
    
    public int next() {
        int i = inOrder.get(l);
        l++;
        return i;      
    }
    
    public boolean hasNext() {
        return l < inOrder.size();       
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */