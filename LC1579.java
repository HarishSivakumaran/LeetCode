// 1579. Remove Max Number of Edges to Keep Graph Fully Traversable

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b)->b[0]-a[0]);
        int[] parentA = new int[n+1];
        int[] parentB = new int[n+1];
        int[] rank = new int[n+1];

        for(int i = 1; i <= n; i++){
            rank[i] = 1;
            parentA[i] = i;
            parentB[i] = i;
        }

        int excess = 0, p1 = 0, p2 = 0, p3 = 0, p4 = 0, conA = n, conB = n;

        for(int[] edge : edges){    
            p1 = findRoot(edge[1], parentA);
            p2 = findRoot(edge[2], parentA);
            p3 = findRoot(edge[1], parentB);
            p4 = findRoot(edge[2], parentB);
            if(edge[0] == 3){
                if(p1 == p2){
                    excess++;
                    continue;
                }
                conA--;
                conB--;
                union(parentA, rank, p1, p2);
                union(parentB, rank, p3, p4);
            } else if (edge[0] == 1){
                if(p1 == p2){
                    excess++;
                    continue;
                }
                conA--;
                union(parentA, rank, p1, p2);
            } else{
                if(p3 == p4){
                    excess++;
                    continue;
                }
                conB--;
                union(parentB, rank, p3, p4);
            }
        }

        return conA > 1 || conB > 1 ? -1 : excess;
    }

    public void union(int[] parent, int[] rank, int p1, int p2){
        if(rank[p1] > rank[p2]){
            rank[p1] += rank[p2];
            parent[p2] = p1;
        }else{
            rank[p2] += rank[p1];
            parent[p1] = p2;
        }
    }

    public int findRoot(int i, int[] parent){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }
}s