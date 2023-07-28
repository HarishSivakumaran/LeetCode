public class 486. Predict the Winner {
    
}
class Solution {
    HashMap<String, int[]> cache = new HashMap();
    public boolean PredictTheWinner(int[] nums) {
        int[] out = getMaxForP1(0, nums.length-1, nums, true);
        return out[0] >= out[1];
    }
    private int[] getMaxForP1(int l, int r, int[] nums, boolean isP1Turn) {
        if(l > r) return new int[]{0, 0};

        String key = l + "-" + r + "-" + isP1Turn;

        if(cache.containsKey(key)) return cache.get(key);

        int[] out = {0, 0}, takingFirst = null, takingLast = null;

        takingFirst = getMaxForP1(l+1, r, nums, !isP1Turn);
        takingLast = getMaxForP1(l, r-1, nums, !isP1Turn);

        if(isP1Turn) {
            if(takingFirst[1] < takingLast[1]) {
                out[0] = takingFirst[0] + nums[l];
                out[1] = takingFirst[1];
            } else {
                out[0] = takingLast[0] + nums[r];
                out[1] = takingLast[1];
            }
        } else {
            if(takingFirst[0] < takingLast[0]) {
                out[0] = takingFirst[0];
                out[1] = takingFirst[1] + nums[l];
            } else {
                out[0] = takingLast[0];
                out[1] = takingLast[1]+nums[r];
            }
        }

        cache.put(key, out);
        return out;
    }
}