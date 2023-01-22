// 228. Summary Ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> out = new ArrayList();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < nums.length; i++){
            boolean justStarted = false;
            if(str.length() == 0){
                str.append(nums[i]);
                justStarted = true;
            }

            if(i+1 >= nums.length || nums[i+1] != nums[i]+1){ 
                if(!justStarted)
                 str.append("->"+nums[i]);
                out.add(str.toString());
                str.replace(0, str.length(), "");
            }

        }

        return out;
        
    }
}
