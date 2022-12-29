// 297. Serialize and Deserialize Binary Tree

// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    HashMap<String, Integer> hm = new HashMap<>();
    public int s = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder  preorder = new StringBuilder ();
        preorder(root,  preorder); 
        String a = preorder.substring(0,preorder.length()-1);

        return a;
       
    }

    public void preorder(TreeNode node, StringBuilder  preorder){
        preorder.append(node == null ? "N" : String.valueOf(node.val)).append(",");

        if(node == null) return;

        preorder(node.left, preorder);


        preorder(node.right, preorder); 
       
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String[] preorder = data.split(",");   

        return buildTree(preorder);
        
    }

    public TreeNode buildTree(String[] preorder){
        if(this.s < 0 || this.s >= preorder.length || preorder[this.s].equals("N")) return null;
        String curr = preorder[this.s];
        TreeNode node = new TreeNode(Integer.parseInt(curr));
        this.s++;
        node.left = buildTree(preorder);
        this.s++;
        node.right = buildTree(preorder);

        return node;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));