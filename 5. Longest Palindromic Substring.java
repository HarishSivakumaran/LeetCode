class Solution {
    public String longestPalindrome(String s) {
        int outl = 0, outr = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            int maxLen = maxLen(c, i, i);                      
            if(maxLen > (outr-outl+1)) {
                outr = i + (maxLen-1)/2;
                outl = i - (maxLen-1)/2;
            }

            int maxLen2 = -1;
            if(i+1 < c.length)
                maxLen2 = maxLen(c, i, i+1); 
            if(maxLen2 > (outr-outl+1)) {
                outr = i + (maxLen2)/2;
                outl = outr+1-maxLen2;
            }
        }

        return s.substring(outl, outr+1);
    }

    private int maxLen(char[] s, int l, int r) {
        int max = 0;
        while(l >= 0 && r < s.length && s[l] == s[r]) {
            max = r-l+1;
            l--;
            r++;
        }

        return max;
    }
}