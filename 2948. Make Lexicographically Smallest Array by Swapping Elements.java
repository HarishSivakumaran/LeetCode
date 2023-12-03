class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] arrWithIndex = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            arrWithIndex[i][0] = nums[i]; 
            arrWithIndex[i][1] = i; 
        }

        Arrays.sort(arrWithIndex, (a, b) -> a[0]-b[0]);
        int l = 0, r = 0;
        
        TreeSet<Integer> index = new TreeSet();
        while(r <= nums.length) {
            if(r-1 >= 0){
                if(r == nums.length || arrWithIndex[r][0]-arrWithIndex[r-1][0] > limit) {
                    //process prev group
                    while(index.size() > 0) {
                        nums[index.pollFirst()] = arrWithIndex[l++][0];
                    }
                }
            }
            if(r < nums.length)
             index.add(arrWithIndex[r][1]);
            r++;
        }

        return nums;
    }
}