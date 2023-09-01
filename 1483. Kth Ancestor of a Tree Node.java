class TreeAncestor {

    int maxH = 16;
    int[][] lifting = null;
    int[] p = null;

    public TreeAncestor(int n, int[] parent) {
        // binary lifting
        lifting = new int[maxH][n];
        p = parent;

        for(int i = 0; i < n; i++) {
            lifting[0][i] = parent[i];
        }

        for(int h = 1; h < maxH; h++) {
            for(int i = 0; i < n; i++) {
                lifting[h][i] = lifting[h-1][i] == -1 ? -1 : lifting[h-1][lifting[h-1][i]];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int h = maxH-1; h >= 0 && node > -1; h--) {
            if((1<<h) <= k) {
                k -= (1<<h);
                node = lifting[h][node];
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */