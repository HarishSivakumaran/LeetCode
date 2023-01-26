// 368. Largest Divisible Subset

class Solution {
    List<Integer> out = new ArrayList();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);   

        int[] l = new int[nums.length]; 
        int[] prev = new int[nums.length]; 
        int max = 0, index = 0;

        for(int i = 0; i < nums.length; i++){
            l[i] = 1;
            prev[i] = -1;
            for(int j = i-1; j >= 0; j-- ){
                if(nums[i] % nums[j] == 0 && (l[j]+1 > l[i])){
                    l[i] = l[j]+1;
                    prev[i] = j;
                }
            }

            if(max < l[i]){
                max = l[i];
                index = i;
            }
        }

        while(index != -1){
            out.add(nums[index]);
            index = prev[index];
        }

        // maxDivisibleSubArray(nums,new ArrayList(),0);
        return out;       
    }

    // public void maxDivisibleSubArray(int[] nums, List<Integer> list, int i){
    //     if(i >= nums.length){
    //         if(this.out.size() < list.size()) this.out = new ArrayList(list);
    //         return;
    //     }

    //     if(list.size() == 0 || nums[i] % list.get(list.size()-1) == 0){
    //         list.add(nums[i]);
    //         maxDivisibleSubArray(nums,list,i+1);
    //         list.remove(list.size()-1);
    //     }
    //     maxDivisibleSubArray(nums,list,i+1);
    // }
}