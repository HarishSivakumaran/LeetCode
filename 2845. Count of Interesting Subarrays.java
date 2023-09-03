class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer, Integer> mod = new HashMap();
        mod.put(0, 1);
        int sum = 0; long ans = 0;

        for(int n : nums) {
            sum += (n%modulo == k ? 1 : 0);
            ans += mod.getOrDefault(((sum%modulo)-k+modulo)%modulo, 0);
            mod.put((sum%modulo), mod.getOrDefault((sum%modulo), 0)+1);
        }
        // int[] count = new int[nums.size()];
        // count[0] = ( nums.get(0)%mod == k ) ? 1 : 0;
        // for(int i = 1; i < nums.size(); i++) {
        //     count[i] += (count[i-1] + (( nums.get(i)%mod == k ) ? 1 : 0));
        // }
        
        return ans;
    }
}