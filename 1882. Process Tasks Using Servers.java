class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        //index, weight
        PriorityQueue<int[]> availableServers = new PriorityQueue<int[]>((a,b) -> {
            if(a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });

         //index, nextAvailableTime
        PriorityQueue<int[]> inProcessServers = new PriorityQueue<int[]>((a,b) -> {
            return a[1]-b[1];
        });

        int[] out = new int[tasks.length];

        int t = 0;

        for(int i = 0; i < servers.length; i++){ 
            availableServers.add(new int[]{i, servers[i]});
        }

        for(int i = 0; i < tasks.length; i++){
            while(inProcessServers.size() > 0 && inProcessServers.peek()[1] <= t){
                availableServers.add(new int[]{inProcessServers.peek()[0], 
                servers[inProcessServers.peek()[0]]});
                inProcessServers.poll();
            }

            if(availableServers.size() > 0) {
                int[] curr = availableServers.poll();
                inProcessServers.add(new int[]{curr[0], t+tasks[i]});
                out[i] = curr[0];
                if(i == t) t++;
            } else {
                i--;
                t = inProcessServers.peek()[1];
            }
        }

        return out;
    }
}