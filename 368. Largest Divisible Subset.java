class Solution {
    List<Integer> out;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); int max = -1, o = -1;
        List<Integer>[] list = new ArrayList[nums.length];
        for(int i = 0; i < nums.length; i++) {
            List<Integer> l = new ArrayList();
            l.add(nums[i]);
            int currLen = 0, index = -1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i]%nums[j] == 0 && list[j].size() > currLen) {
                    currLen = list[j].size(); index = j;
                }
            }
            if(index != -1) {
                for(int n : list[index]) l.add(n);
            }

            list[i] = l;
            if(l.size() > max) {
                max = l.size();
                o = i;
            }
        }

        return list[o];

    }

    // private void getMax(int[] nums, int i, List<Integer> curr) {
    //     if(i >= nums.length) {
    //         if(out == null || curr.size() > out.size()) {
    //             out = new ArrayList<>(curr);
    //         }
    //         return;
    //     }

    //     //take
    //     if(curr.size() == 0 || (nums[i]%curr.get(curr.size()-1)) == 0){
    //         curr.add(nums[i]);
    //         getMax(nums, i+1, curr);
    //         curr.remove(curr.size()-1);
    //     }

    //     //not take
    //     getMax(nums, i+1, curr);

    // }


}