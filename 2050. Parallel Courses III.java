class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n];
        int[] toReach = new int[n];
        HashMap<Integer, List<Integer>> adjList = new HashMap();
        for(int[] e : relations) {
            indegree[e[1]-1]++;
            adjList.computeIfAbsent(e[0]-1, v -> new ArrayList()).add(e[1]-1);
        }

        int maxT = 0;


        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                toReach[i] = time[i];
                maxT = Math.max(maxT, toReach[i]);
            }
        }


        while(q.size() > 0) {
            int len = q.size();
            while(len > 0) {
                int curr = q.poll();
                if(adjList.containsKey(curr))
                for(int next : adjList.get(curr)) {
                    indegree[next]--;
                    toReach[next] = Math.max(toReach[next], toReach[curr]+time[next]);
                    maxT = Math.max(maxT, toReach[next]);
                    if(indegree[next] == 0) q.add(next);
                }
            len--;
            }
        }

        return maxT;
    }
}