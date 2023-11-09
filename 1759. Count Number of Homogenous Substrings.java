class Solution {
    public int countHomogenous(String s) {
        char[] c = s.toCharArray();
        int l = 0, r = 0;
        int mod = 1000000007;
        long ans = 0;
        while(r < c.length) {
            if(c[l] == c[r]) { 
                r++;
            } else {
                // String str = s.substring(l, r);
                // maxStrCount.put(str, maxStrCount.getOrDefault(str, 0)+1);
                ans += ((long)(r-l)*(r-l+1))/2;
                ans %= mod;
                l = r;
                r++;
            }
        }
        if(l < c.length){
            ans += ((long)(r-l)*(r-l+1))/2;
            ans %= mod;
        }

        return (int)ans;

    }
}