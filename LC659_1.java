// 659. Split Array into Consecutive Subsequences

public class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        HashMap<Integer, Integer> nextWantedNum = new HashMap();

        for(int n : nums){
            count.put(n , count.getOrDefault(n,0)+1);
        }

        for(int i : nums){
            if(count.get(i) == 0){
                continue;
            }else if(nextWantedNum.getOrDefault(i,0) > 0){
                    nextWantedNum.put(i, nextWantedNum.get(i)-1);
                    nextWantedNum.put(i+1, nextWantedNum.getOrDefault(i+1, 0)+1);
                    count.put(i, count.get(i)-1);
            }else if(count.getOrDefault(i,0) > 0 && count.getOrDefault(i+1,0) > 0 && count.getOrDefault(i+2,0) > 0){
                    count.put(i, count.get(i)-1);
                    count.put(i+1, count.get(i+1)-1);
                    count.put(i+2, count.get(i+2)-1);
                    nextWantedNum.put(i+3, nextWantedNum.getOrDefault(i+3,0)+1);
            }else{
                return false;
            }
        }
        return true;
        
    }

}{

}
