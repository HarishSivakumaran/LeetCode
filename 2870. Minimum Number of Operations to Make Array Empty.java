class Solution {
    public static HashMap<Integer, Integer> cache = new HashMap();
    
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int ans = 0;

        for(int v : map.values()) {
            if(cache.containsKey(v)) {
                if(cache.get(v) == -1) return -1;
                ans += cache.get(v);
                continue;
            }
            int countTwo = 0, min = -1;
            while(v-(2*countTwo) >= 0) {
                if((v-(2*countTwo))%3 == 0) {
                    min = countTwo + (v-(2*countTwo))/3;
                    break;
                }
                countTwo++;
            }
            cache.put(v, min);
            if(min == -1) return -1;
            ans += min;
        }

        return ans;
    }
}