class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] ans = {0, 0, 0}; //MPG
        int[] cache = {0, 0, 0}; //MPG
        for(int i = 0; i < garbage.length; i++) {
            int g = 0, m = 0, p = 0;
            char[] gar = garbage[i].toCharArray();
            for(int j = 0; j < gar.length; j++) {
                if(gar[j] == 'G') g++;
                if(gar[j] == 'M') m++;
                if(gar[j] == 'P') p++;
            }

            if(g > 0) {
                ans[0] += cache[0]+g;
                cache[0] = 0;
            }
            if(m > 0) {
                ans[1] += cache[1]+m;
                cache[1] = 0;
            }
            if(p > 0) {
                ans[2] += cache[2]+p;
                cache[2] = 0;
            }
            if(i < travel.length)
            for(int k = 0; k < 3; k++) cache[k] += travel[i];
        }

        return ans[0] + ans[1] + ans[2];
    }
}