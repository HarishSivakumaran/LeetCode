class Solution {
    public int majorityElement(int[] nums) {
        int max = 0, val = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
            int v = map.get(n);
            if(v > max) {
                max = v;
                val = n;
            }
        }

        return val;

    }
}