// 427. Construct Quad Tree

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constr(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    public Node constr(int[][] grid, int t, int b, int l, int r) {
        if (l > r || t > b)
            return null;
        int curr = grid[t][l];
        Node node = new Node();
        if (check(grid, t, b, l, r, curr)) {
            node.val = curr == 1;
            node.isLeaf = true;
        } else {
            node.topLeft = constr(grid, t, b - (b - t + 1) / 2, l, r - (r - l + 1) / 2);
            node.topRight = constr(grid, t, b - (b - t + 1) / 2, l + ((r - l + 1) / 2), r);
            node.bottomLeft = constr(grid, t + ((b - t + 1) / 2), b, l, r - (r - l + 1) / 2);
            node.bottomRight = constr(grid, t + ((b - t + 1) / 2), b, l + (r - l + 1) / 2, r);
        }

        return node;

    }

    public boolean check(int[][] grid, int t, int b, int l, int r, int ref) {
        for (int i = t; i <= b; i++) {
            for (int j = l; j <= r; j++) {
                if (grid[i][j] != ref)
                    return false;
            }
        }

        return true;
    }
}