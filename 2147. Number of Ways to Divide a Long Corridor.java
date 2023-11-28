class Solution {
    int mod = 1000000007;
    HashMap<Pair<Integer, Integer>, Long> cache = new HashMap();
    public int numberOfWays(String corridor) {
        char[] arr = corridor.toCharArray();
        int[] seatCount = new int[arr.length+1];
        for(int i = 1; i <= arr.length; i++) {
            seatCount[i] = seatCount[i-1];
            if(arr[i-1] == 'S') seatCount[i]++;
        }
        if((seatCount[seatCount.length-1] & 1) == 1) return 0;

        return (int) getWays(arr, seatCount, 1, 0);
    }

    private long getWays(char[] arr, int[] seatCount, int index, int prev) {
        if(prev >= seatCount.length-1) return 1;
         
        if(index >= seatCount.length || seatCount[index]-seatCount[prev] > 2) 
            return 0;
        
        Pair pair = new Pair(prev, index);

        if(cache.containsKey(pair)) return cache.get(pair);

        long ways = 0;
        // cut
        if(seatCount[index]-seatCount[prev] == 2) {
            ways += getWays(arr, seatCount, index+1, index);
            ways %= mod;
        }

        // don't cut
            ways += getWays(arr, seatCount, index+1, prev);
            ways %= mod;

        cache.put(pair, ways);
        return ways;


    }
}