class Solution {
    HashMap<Integer, HashSet<Integer>> superAdjList = new HashMap();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap();
        for(int[] p : prerequisites) {
            adjList.computeIfAbsent(p[1], v -> new HashSet()).add(p[0]);
            superAdjList.computeIfAbsent(p[1], v -> new HashSet()).add(p[0]);
        }
        List<Boolean> out = new ArrayList();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
            buildSuperAdjList(adjList,i, visited);
        
        for(int[] q : queries){
            out.add(checkIfCorrect(adjList, q[1], q[0]));
        }

        return out;
    }

    private void buildSuperAdjList(HashMap<Integer, HashSet<Integer>> adjList, int curr, boolean[] visited){
        if(adjList.get(curr) == null || visited[curr]) return;

        for(int next: adjList.get(curr)){
            buildSuperAdjList(adjList, next, visited);
            if(superAdjList.get(next) != null)
                superAdjList.get(curr).addAll(superAdjList.get(next));
        }

        visited[curr] = true;
    }

    private boolean checkIfCorrect(HashMap<Integer, HashSet<Integer>> adjList, int from, int to){
        if(adjList.get(from) != null && (adjList.get(from).contains(to) 
        || superAdjList.get(from).contains(to))) return true;

        return false;
    }
}