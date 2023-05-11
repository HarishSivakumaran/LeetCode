// 1035. Uncrossed Lines

class Solution {
    Integer[][] map;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
     // fancy longest common subsequence
        map = new Integer[nums1.length][nums2.length];
        return getUncrossedLines(nums1, nums2, 0, 0);
    }

    public int getUncrossedLines(int[] nums1, int[] nums2, int i, int j){
        if(i >= nums1.length || j >= nums2.length) return 0;

        if(map[i][j] != null) return map[i][j];

        int count = 0;

        if(nums1[i] == nums2[j]){
            count =  1 + getUncrossedLines(nums1, nums2, i+1, j+1);
        }else{
            count = Math.max(getUncrossedLines(nums1, nums2, i+1, j), getUncrossedLines(nums1, nums2, i, j+1));
        }

        return map[i][j] = count;
    }
}