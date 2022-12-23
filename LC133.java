// 133. Clone Graph


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(this.map.containsKey(node.val)) return this.map.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<Node> ());
        this.map.put(node.val, newNode);

        for(Node nNode : node.neighbors){
            newNode.neighbors.add(cloneGraph(nNode));
        }
         return newNode;
        
    }
}