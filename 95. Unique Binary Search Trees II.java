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
    HashMap<String, List<TreeNode>> cache = new HashMap();
    public List<TreeNode> generateTrees(int n) {
        return bst(1, n);
    }
    
    private List<TreeNode> bst(int l, int r) {
        List<TreeNode> out = new ArrayList();
        if(l > r) {
            out.add(null);
            return out;
        }
        if(l == r) {
            out.add(new TreeNode(l));
            return out;
        }

        String key = l + "-" + r;
        if(cache.containsKey(key)) return cache.get(key);

        for(int root = l; root <= r; root++) {
            List<TreeNode> possLefts = bst(l, root-1);
            List<TreeNode> possRights = bst(root+1, r);
            for(TreeNode left : possLefts){
                for(TreeNode right : possRights) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = left;
                    rootNode.right = right;
                    out.add(rootNode);
                }
            }
        }

        cache.put(key, out);

        return out;
    }
}