class Solution {
    int mod = 1000000007;
    HashMap<Integer, Long> cache = new HashMap();
    public int numFactoredBinaryTrees(int[] arr) {
        long ans = 0;
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet();
        for(int n : arr) set.add(n);
        for(int n : arr) {
            ans += getWays(n, arr, set);
            ans %= mod;
        }

        return (int)ans;
    }

    private long getWays(int val, int[] arr, HashSet<Integer> set) {
        long ways = 1;
        if(cache.containsKey(val)) return cache.get(val);
        HashSet<Integer> added = new HashSet();

        for(int i = 0; i < arr.length && arr[i] < val; i++) {
            if(val % arr[i] == 0 && set.contains(val/arr[i]) && (!added.contains(arr[i])
            && !added.contains(val/arr[i]))) {
               long child = (getWays(arr[i], arr, set)%mod) * 
                            (getWays(val/arr[i], arr, set)%mod);
               child %= mod;
               if(val/arr[i] != arr[i]) {
                   child *= 2;
                   child %= mod;
               }
               ways += child;
               ways %= mod;
               added.add(arr[i]);
               added.add(val/arr[i]);
            }
        }
        
        cache.put(val,ways);
        return ways;

    }
}