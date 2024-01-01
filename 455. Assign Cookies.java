class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;
        int l = 0;

        for(int i = 0; i < g.length; i++) {
            l = getNextMax(s, l, s.length-1, g[i]);
            if(l != -99) {
                ans++;
                l++;
            } else {
                break;
            }
        }

        return ans;
    }

    private int getNextMax(int[] arr, int l, int r, int v) {
        int m = 0;
        while(l <= r) {
            m = l + (r-l)/2;
            if(arr[m] < v){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l < arr.length && arr[l] >= v ? l : -99;
    }
}