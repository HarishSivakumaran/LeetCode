class Solution {
    public int maxScore(String s) {
        int[] prefix = new int[s.length()];
        for(int i = 0; i < prefix.length; i++) {
            prefix[i] = (i-1 >= 0 ? prefix[i-1] : 0) + 
                        (s.charAt(i) == '1' ? 1 : 0);
        }

        int max = 0;
        for(int i = 0; i < prefix.length-1; i++) {
            int ans = i+1-(2*prefix[i]) + prefix[prefix.length-1];
            if(ans > max) max = ans;
        }

        return max;
    }
}