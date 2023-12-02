class Solution {
    // public long beautifulSubstrings(String s, int k) {
    //     HashMap<String, Long> cache = new HashMap();
    //     int c = 0, v = 0;
    //     long ans = 0;
    //     cache.put(0+"-"+0, 1l);

    //     int len = 1;
    //     for(len = 1; (len*len)%(k*4) > 0; len++);
        
    //     for(int i = 0; i < s.length(); i++) {
    //         if(s.charAt(i) == 'a' ||
    //           s.charAt(i) == 'e' ||
    //           s.charAt(i) == 'i' ||
    //           s.charAt(i) == 'o' || s.charAt(i) == 'u') {
    //             v++;
    //         } else {
    //             c++;
    //         }
            
    //         for(int j = len/2; j <= Math.min(v, c); j += (len/2)) {
    //             // to get j, j we should remove 
    //             String req = (v-j) + "-" + (c-j);
    //             ans += cache.getOrDefault(req, 0l);
    //         }
            
    //         cache.put(v+"-"+c, cache.getOrDefault(v+"-"+c, 0l)+1l);
    //     }
        
    //     return ans;
    // }
        public long beautifulSubstrings(String s, int k) {
        int n = s.length(), v = 0, l;
        for (l = 1; l * l % (k * 4) > 0; ++l);
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashMap<Integer, Integer>[] seen = new HashMap[l];
        for (int i = 0; i < l; i++) {
            seen[i] = new HashMap<>();
        }
        seen[l - 1].put(0, 1);
        long res = 0;
        for (int i = 0; i < n; i++) {
            v += vowels.contains(s.charAt(i)) ? 1: -1;
            int c = seen[i % l].getOrDefault(v, 0);
            res += c;
            seen[i % l].put(v, c + 1);
        }
        return res;
    }
}