class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int n : arr) map.put(n, map.getOrDefault(n, 0)+1);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) ->
        a[1]-b[1] ); //vsl, count
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) pq.add(new int[]{entry.getKey(), entry.getValue()});

        while(pq.size() > 0 && k >= pq.peek()[1]) {
            k -= pq.poll()[1];
        }

        return pq.size();
    }
}