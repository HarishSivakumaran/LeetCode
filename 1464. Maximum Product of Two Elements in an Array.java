class Solution {
    public int maxProduct(int[] nums) {
        int max = -1, secMax = -1;
        for(int n : nums) {
            if(n > max) {
                secMax = max;
                max = n;
            } else if(n > secMax) {
                secMax = n;
            }
        }

        return (max-1)*(secMax-1);
    }
}


