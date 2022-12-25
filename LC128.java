// 128. Longest Consecutive Sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>(); 
        for(int i: nums) hs.add(i);
        int ans = 0;
        for(int i: nums){
            if(hs.contains(i-1)) continue;
            int count = 1;
            while(hs.contains(i+1)){
                i++;
                count++;
            }
            ans = Math.max(ans, count);

        }
        return ans;
        
    }
}