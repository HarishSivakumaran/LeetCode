class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int l = 0, r = 0, max = -1, sum = 0;
        char[] arr = colors.toCharArray();

        while(r < neededTime.length) {
            if(arr[r] != arr[l]) {
                ans += (sum-max);
                sum = 0;
                max = -1;
                l = r;
            }
            if(neededTime[r] > max) max = neededTime[r];
            sum += neededTime[r];
            r++;
        }
        ans += (sum-max);

        return ans;
    }
}