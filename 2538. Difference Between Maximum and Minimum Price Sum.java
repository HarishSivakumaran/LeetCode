class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        Queue<Integer> q = new LinkedList();
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        int[] indegree = new int[n];
        int[] inclRoot = new int[n];
        int[] exclRoot = new int[n];
        long res = 0;


        for(int[] e : edges) {
            adjList.computeIfAbsent(e[0], v -> new ArrayList()).add(e[1]);
            adjList.computeIfAbsent(e[1], v -> new ArrayList()).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 1){
                q.add(i);
            } else{
                exclRoot[i] = price[i];
            }
            inclRoot[i] = price[i];
        }

        long value = 0;

        while(q.size() > 0) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int curr = q.poll();
                indegree[curr]--;
                for(int next : adjList.get(curr)) {
                    if(indegree[next] > 0) {
                        value = Math.max(value, Math.max(
                            (long)exclRoot[next]+inclRoot[curr],
                            (long)exclRoot[curr]+inclRoot[next]
                        ));
                        inclRoot[next] = Math.max(inclRoot[next],
                         price[next]+inclRoot[curr]);
                        exclRoot[next] = Math.max(exclRoot[next], 
                         price[next]+exclRoot[curr]);
                        if(--indegree[next] == 1) {
                            q.add(next);
                        }
                    }
                }

            }            
        }

        return value;
    }
}

