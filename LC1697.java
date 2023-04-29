// 1697. Checking Existence of Edge Length Limited Paths

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        HashMap<int[], Integer> map = new HashMap();

        for(int i = 0; i < queries.length; i++){
            map.put(queries[i], i);
        }

        Arrays.sort(queries, (q1, q2) -> q1[2]-q2[2]);
        Arrays.sort(edgeList, (q1, q2) -> q1[2]-q2[2]);

        int[] rank = new int[n];
        int[] parent = new int[n];

        for(int i = 0; i < n;i++){
            rank[i] = 1;
            parent[i] = i;
        }

        int edge = 0;
        boolean[] out = new boolean[queries.length];

        for(int[] currQ : queries){
            while(edge < edgeList.length && edgeList[edge][2] < currQ[2]){
                int p1 = findRoot(parent, edgeList[edge][0]);
                int p2 = findRoot(parent, edgeList[edge][1]);
                edge++;
                if(p1 == p2) continue;
                if(rank[p1] > rank[p2]){
                    rank[p1] += rank[p2];
                    parent[p2] = p1;
                }else{
                    rank[p2] += rank[p1];
                    parent[p1] = p2;
                }
            }

            int p1 = findRoot(parent, currQ[0]);
            int p2 = findRoot(parent, currQ[1]);
            
            out[map.get(currQ)] = p1 == p2;
        }


        return out;
    }

    public int findRoot(int[] par, int i){
        while(par[i] != i){
            par[i] = par[par[i]];
            i = par[i];
        }
        return i;
    }
}