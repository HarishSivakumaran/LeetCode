class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length-1]-nums[0], posMax = 0;

        while(l <= r) {
            posMax = l + (r-l)/2;

            if(countPairs(nums, posMax) >= p) {
                r = posMax-1;
            } else {
                l = posMax+1;
            }
        }

        return l;
    }

    private int countPairs(int[] nums, int max) {
        int count = 0, i = 0;

        while(i < nums.length-1) {
            if(nums[i+1]-nums[i] <= max) {
                count++;
                i++;
            }
            i++;
        }

        return count;
    }
}