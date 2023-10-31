class Solution {
    public int[] findArray(int[] pref) {
        int prev = 0;
        for(int i = 0; i < pref.length; i++) {
            int ans = prev ^ pref[i];
            prev ^= ans;
            pref[i] = ans;
        }

        return pref;
    }
}