class Solution {
    HashMap<String, Integer> cache = new HashMap();
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0]-b[0]);
        return getMaxValue(events, 0, 0, k);
    }

    private int getMaxValue(int[][] events, int i, int prevEventEnd, int k){
        if(k == 0 || i >= events.length) return 0;

        String key = i + "-" + k + "-" + prevEventEnd;

        if(cache.containsKey(key)) return cache.get(key);

        int val = 0;

        // Don't attend this event
        val = getMaxValue(events, i+1, prevEventEnd, k);


        // attend this event if possible
        if(prevEventEnd < events[i][0]){
            val = Math.max(val, events[i][2]+getMaxValue(events, i+1, events[i][1], k-1));
        }

        cache.put(key, val);

        return val;
    }
}