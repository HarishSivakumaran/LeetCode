class Solution {
    public int getWinner(int[] arr, int k) {
        int[] ans = {arr[0], 0};

        for(int i = 1; i < arr.length; i++) {
            if(ans[0] > arr[i]) {
                ans[1]++;
            } else {
                ans[0] = arr[i];
                ans[1] = 1;
            }
            if(ans[1] == k) return ans[0];
        }

        return ans[0];
    }
}