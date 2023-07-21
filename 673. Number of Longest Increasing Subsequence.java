class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] longIncSub = new int[nums.length];
        int[] ways = new int[nums.length];
        int max = -1;

        for(int i = nums.length-1; i >= 0; i--) {
            int len = 0, prevMaxLenCount = 1;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]){
                    if(longIncSub[j] > len){
                        prevMaxLenCount = ways[j];
                        len = longIncSub[j];
                    } else if( len == longIncSub[j]) {
                        prevMaxLenCount += ways[j];
                    }
                }
            }
            longIncSub[i] = len+1;
            ways[i] = prevMaxLenCount;
            if(len + 1 > max){
                max = len+1;
            }
        }

        System.out.println(Arrays.toString(ways));
        System.out.println(Arrays.toString(longIncSub));

        if(max == 1) {
            return nums.length;
        } else {
            int o = 0;
            for(int i = 0; i < nums.length; i++) {
                if(longIncSub[i] == max) o += ways[i];
            }
            return o;
        }
    }
}