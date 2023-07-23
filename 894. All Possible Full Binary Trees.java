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
    HashMap<Integer, List<TreeNode>> cache = new HashMap();
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0) return new ArrayList<TreeNode>();
        if(n == 1) return List.of(new TreeNode());
        if(cache.containsKey(n)) return cache.get(n);

        List<TreeNode> res = new ArrayList();
        for(int i = 1; i < n; i+=2){
            var left = allPossibleFBT(i);
            var right = allPossibleFBT(n-1-i);

            for(var l : left){
                for(var r: right){
                    TreeNode node = new TreeNode();
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        cache.put(n, res);
        return res;
    }

    // private void buildTree(TreeNode node, TreeNode root, List<TreeNode> out) {
    //     if(reqNodes < 1) return;

    //     if(reqNodes == 1){
    //         out.add(clone(root));
    //         return;
    //     }

    //     node.left = new TreeNode(0);
    //     node.right = new TreeNode(0);
    //     int beforeAll = this.reqNodes;
    //     this.reqNodes -= 2;
    //     int before = this.reqNodes;
    //     buildTree(node.left, root, out);
    //     if(reqNodes > 2){
    //         // with the same left try right
    //         buildTree(node.right, root, out);
    //     }

    //     if(before > 2){
    //         // remove all the children of left and then try right
    //         this.reqNodes = before;
    //         node.left.left = null;
    //         node.left.right = null;
    //         buildTree(node.right, root, out);
    //     }

 
    //     node.left = null;
    //     node.right = null;
    //     this.reqNodes = beforeAll;

    // }

    // private TreeNode clone(TreeNode node ) {
    //     if(node == null) return null;

    //     TreeNode newNode = new TreeNode(0);
    //     newNode.left = clone(node.left);
    //     newNode.right = clone(node.right);

    //     return newNode;
    // }
}