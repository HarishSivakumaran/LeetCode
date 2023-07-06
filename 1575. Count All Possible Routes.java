class Solution {
    int mod = 1000000007;
    HashMap<String, Integer> cache = new HashMap();
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        // index : index,diff
        HashMap<Integer, List<int[]>> diffMap = new HashMap();

        for(int i = 0; i < locations.length; i++){
            for(int j = i+1; j < locations.length; j++) {
                diffMap.computeIfAbsent(i,
                 v -> new ArrayList()).add(new int[]{j, Math.abs(locations[i]-locations[j])});
                diffMap.computeIfAbsent(j, 
                 v -> new ArrayList()).add(new int[]{i, Math.abs(locations[i]-locations[j])});
            }
        }

        return (int)getRoutes(start, finish, fuel, diffMap);
    }

    public long getRoutes(int index,
        int e, int f, HashMap<Integer, List<int[]>> diffMap){
            if(f < 0) return 0;

            String key = index + "-" + f;
            if(cache.containsKey(key)) return cache.get(key);

            long val = 0l;

            if(f > 0)
            for(int[] nextDest : diffMap.get(index)) {
                if(nextDest[1] <= f){
                    val += getRoutes(nextDest[0], e, f-nextDest[1], diffMap);
                }
                val %= mod;
            }
        cache.put(key, (int)(val + (index == e ? 1 : 0)));
        return val + (index == e ? 1 : 0);
    }
}