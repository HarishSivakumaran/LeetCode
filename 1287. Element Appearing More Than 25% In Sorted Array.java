class Solution {
    public int findSpecialInteger(int[] arr) {
        int l = 0, r = 0;
        while(r <= arr.length) {
            int v = r < arr.length ? arr[r] : -1;
            if(arr[l] != v) {
                double ratio = (double)(r-l)/arr.length;
                if(ratio > 0.25) return arr[l];
                l = r;
            }
            r++;
        }

        return -1;
    }
}