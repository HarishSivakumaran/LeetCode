public class Solution {
    Integer[][][] cache = null;
    public int sol(int[] a, int[] b, int k) {
        cache = new Integer[a.length][k+1][2];
        int[] ans = findMax(a, b, 0, k);
        return Math.min(ans[0], ans[1]);
    }
    public int[] findMax(int[] a, int[] b, int index, int k) {
        if(k == 0 || index >= a.length) return new int[]{0, 0};
        
        if(cache[index][k][0] != null) return cache[index][k];
        //choose the current one
        int[] max = findMax(a, b, index+1, k-1);
        max[0] += a[index];
        max[1] += b[index];

        int[] max2 = findMax(a, b, index+1, k);

        if(Math.min(max[0], max[1]) > Math.min(max2[0], max2[1])) {
            return cache[index][k] = max.clone();
        } else {
            return cache[index][k] = max2.clone();
        }
    }
} 