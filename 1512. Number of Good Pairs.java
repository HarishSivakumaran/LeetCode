class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        int ans = 0;
        for(int n : nums) {
            ans += count.getOrDefault(n , 0);
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        return ans;
    }
}