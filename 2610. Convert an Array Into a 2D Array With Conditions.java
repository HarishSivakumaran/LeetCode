class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> out = new ArrayList(100);
        int[] count = new int[nums.length+1];

        for(int n : nums) {
            count[n]++;
            if(out.size() < count[n]) {
                out.add(new ArrayList(20));
            }
            out.get(count[n]-1).add(n);
        }

        return out;
    }
}