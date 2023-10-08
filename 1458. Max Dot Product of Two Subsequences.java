class Solution {
    Integer[][][] cache = null;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        cache = new Integer[nums1.length+1][nums2.length+1][2];
        return getMax(nums1, nums2, 0 , 0, false);
    }

    private int getMax(int[] n1, int[] n2, int i, int j, boolean selected) {
        if(i >= n1.length || j >= n2.length) return selected ? 0 : Integer.MIN_VALUE;

        if(cache[i][j][selected ? 0 : 1] != null) return cache[i][j][selected ? 0 : 1];

        int max = (n1[i]*n2[j]) + getMax(n1, n2, i+1, j+1, true);
        max = Math.max(max, getMax(n1, n2, i+1, j, selected));
        max = Math.max(max, getMax(n1, n2, i, j+1, selected));
        max = Math.max(max, getMax(n1, n2, i+1, j+1, selected));


        return cache[i][j][selected ? 0 : 1] = max;      
    }
}