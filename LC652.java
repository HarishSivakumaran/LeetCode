// 652. Find Duplicate Subtrees

class Solution {
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root, new HashMap<String, Integer>());
        return res;
    }

    public String traverse(TreeNode node, HashMap<String, Integer> cache) {
        if (node == null)
            return "N";

        String stringTreeRep = "(" + traverse(node.left, cache) + ")-(" + node.val + ")-(" + traverse(node.right, cache)
                + ")";

        cache.put(stringTreeRep, cache.getOrDefault(stringTreeRep, 0) + 1);

        if (cache.get(stringTreeRep) == 2) {
            res.add(node);
        }
        return stringTreeRep;
    }
}