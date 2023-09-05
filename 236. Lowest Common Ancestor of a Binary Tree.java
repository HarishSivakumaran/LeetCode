/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // HashMap<TreeNode, TreeNode> parent = new HashMap();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode w) {
        if(root == null || root == p || root == w) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, w);
        TreeNode right = lowestCommonAncestor(root.right, p, w);
        if(left != null && right != null) return root;
        return left == null ? right : left;
        // buildParentTree(root, null);
        // HashSet<TreeNode> visited = new HashSet();

        // Queue<TreeNode> q = new LinkedList();
        // q.add(p);
        // q.add(w);

        // while(q.size() > 0) {
        //     TreeNode curr = q.poll();
        //     if(visited.contains(curr)) return curr;
        //     visited.add(curr);
        //     if(parent.get(curr) != null) {
        //         q.add(parent.get(curr));
        //     }
        // }

        // return null;
    }

    // private void buildParentTree(TreeNode node, TreeNode p) {
    //     if(node == null) return;
    //     parent.put(node, p);
    //     buildParentTree(node.left, node);
    //     buildParentTree(node.right, node);
    // }
}