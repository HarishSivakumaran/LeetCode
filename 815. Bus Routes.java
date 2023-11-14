class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, List<Integer>> busesInNodes = new HashMap();
        for(int j = 0; j < routes.length; j++) {
            int[] r = routes[j];
            for(int i = 0; i < r.length; i++) {
                busesInNodes.computeIfAbsent(r[i], v -> new ArrayList()).add(j);
            }
        }

        Queue<Integer> q = new LinkedList();
        for(int bus : busesInNodes.get(source)) q.add(bus);
        HashSet<Integer> visited = new HashSet();
        int buses = 1;

        while(q.size() > 0) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int currBus = q.poll();
                if(visited.contains(currBus)) continue;
                visited.add(currBus);

                for(int nextStop : routes[currBus]) {
                    if(nextStop == target) return buses;

                    for(int nextBus : busesInNodes.get(nextStop)) {
                         if(visited.contains(nextBus)) continue;
                         q.add(nextBus);
                    }
                }

            }
            buses++;
        }

        return -1;
    }
}