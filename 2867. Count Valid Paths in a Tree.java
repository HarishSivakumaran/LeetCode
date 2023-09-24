class Solution {
    boolean[] prime = null;
    Integer[][][] cache = null;
    public long countPaths(int n, int[][] edges) {
        prime = new boolean[n+1];
        calcPrime(n);
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        for(int[] e : edges) {
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e[1]);
            adjList.computeIfAbsent(e[1], v -> new ArrayList()).add(e[0]);
        }
        long ans = 0;
        DSU dsu = new DSU(n);

        for(int[] e : edges) {
            if(!prime[e[0]] && !prime[e[1]]) {
                dsu.union(e[0], e[1]);
            }
        }

        for(int i = 2; i <= n; i++) {
            if(!prime[i]) continue;
            long paths = 0;
            long totalOtherNodes = 0;
            for(int next : adjList.get(i)) {
                if(prime[next]) continue;
                totalOtherNodes += dsu.rank[dsu.findRoot(next)];
            }
            paths += totalOtherNodes; //prime to other nodes

            long compToComp = 0;

            for(int next : adjList.get(i)) {
                if(prime[next]) continue;
                long curr = dsu.rank[dsu.findRoot(next)];
                compToComp += curr * (totalOtherNodes-curr);
            }
            compToComp /= 2;
            paths += compToComp;
            ans += paths;

        }

        return ans;

    }
    
    // private int connectedNodes(int i, HashMap<Integer, List<Integer>> adjList, int primes, int prev) {
    //     if(primes > 0 && prime[i]) return 0;
    //     if(cache[i][prev][0] != null) return cache[i][prev][0];
        
    //     int nodes = 1;
    //     List<Integer> child = new ArrayList();
    //     if(adjList.containsKey(i)) {
    //         for(int next : adjList.get(i)){
    //             if(prev == next) continue;
    //             if(prime[i]){
    //                 child.add(connectedNodes(next, adjList, primes + 1, i));
    //             } else {
    //                 nodes += connectedNodes(next, adjList, primes, i);
    //             }
    //         }
    //     }
        
    //     if(prime[i]) {
    //         nodes = 0;
    //         for(int k = 0; k < child.size(); k++){
    //             nodes += child.get(k); // prime and these nodes
    //             for(int j = k+1; j < child.size(); j++) {
    //                 //prime in between these nodes
    //                 nodes += (child.get(k)*child.get(j));
    //             }
    //         }
    //     }
        
    //     return cache[i][prev][0] = nodes;
    // }
    
    private void calcPrime(int n) { //seive
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j = i+i; j <= n; j+=i) {
                    prime[j] = false;
                }
            }
        }
    }
}

class DSU{
    int[] rank;
    int[] parent;
    DSU(int n) {
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int i) {
        while(parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public void union(int a, int b) {
        int p1 = findRoot(a);
        int p2 = findRoot(b);
        if(p1 == p2) return;

        if(rank[p1] > rank[p2]) {
            rank[p1] += rank[p2];
            parent[p2] = p1;
        } else {
            rank[p2] += rank[p1];
            parent[p1] = p2;
        }
    }


}