// 787. Cheapest Flights Within K Stops


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Dijkstra's'
        // HashMap<Integer,HashMap<Integer,Integer>> hm = new HashMap<>();

        // for(int[] fl : flights){
        //      HashMap<Integer,Integer> toDetails = null;
        //     if(!hm.containsKey(fl[0])) {
        //         toDetails = new HashMap<>();
        //         hm.put(fl[0], toDetails);
        //     }else{
        //         toDetails = hm.get(fl[0]);
        //     }
        //     toDetails.put(fl[1], fl[2]);          
        // }
        
        // int[] dist = new int[n];

        // HashSet<String> visited = new HashSet();

        // Arrays.fill(dist, Integer.MAX_VALUE);

        // dist[src] = 0;

        // int level = 0;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]); // node, dist, level

        // pq.add(new int[]{src, dist[src], level});

        // while(pq.size() > 0){

        //     int[] currCity = pq.poll();

        //     String key = currCity[0] +"-"+ currCity[2];

        //     if(visited.contains(key)) continue;

        //     visited.add(key);

        //     HashMap<Integer,Integer> toDetails = hm.get(currCity[0]);

        //     if(toDetails == null) continue; // no to flights from current stop

        //     for (Map.Entry<Integer,Integer> entry : toDetails.entrySet()){
        //         if(k == currCity[2] && entry.getKey() != dst) continue;

        //         if(dist[entry.getKey()] > entry.getValue() + dist[currCity[0]] ) dist[entry.getKey()] = entry.getValue() + dist[currCity[0]];

        //         if(currCity[2]+1 <= k){
        //             pq.add(new int[]{entry.getKey(), dist[entry.getKey()], currCity[2]+1});
        //         }
        //     }

        // }

        // Bellman ford

        int[] prices = new int[n];

        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] temp = Arrays.copyOf(prices, prices.length);
            for(int[] edge : flights){ // s, d, p
                if(prices[edge[0]] == Integer.MAX_VALUE) continue;
                if(prices[edge[0]] + edge[2] < temp[edge[1]]) temp [edge[1]] = prices[edge[0]] + edge[2];
            }
            prices = temp;
        }




        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

    }
}