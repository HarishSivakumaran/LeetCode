// 1584. Min Cost to Connect All Points

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length < 2) return 0;

        HashSet<int[]> hs = new HashSet<>();

        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());

        pq.add(new Pair(points[0],0));
        int cost = 0;

        while(hs.size() < points.length){
            Pair<int[], Integer> currPair = pq.poll();
            int[] currPoint = currPair.getKey();

            if(hs.contains(currPoint)) continue;

            hs.add(currPoint);
            cost += currPair.getValue();

            for(int[] point : points){
                if(hs.contains(point)) continue;
                int dist = Math.abs(currPoint[0]-point[0]) +  Math.abs(currPoint[1]-point[1]);
                pq.add(new Pair(point, dist));
            }
        }

        return cost;
        
    }
}