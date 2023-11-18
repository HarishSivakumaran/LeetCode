class Solution {
    public int maxFrequency(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int freq = 0;

        for(int i = 0; i <= nums.length; i++) {
            int curr = i < nums.length ? nums[i] : -1;
            if(i-1 >= 0 && nums[i-1] != curr) {
                //handle change and recalc freq
                int currFreq = freq;
                int index = i-freq-1, avail = k;
                while(index >= 0 && (nums[index]+avail >= nums[i-1])) {
                    avail -= (nums[i-1]-nums[index]);         
                    currFreq++;
                    index--;   
                }
                if(currFreq > ans) ans = currFreq;
                freq = 0;
            }
            freq++;
        }


        return ans;
    }
}