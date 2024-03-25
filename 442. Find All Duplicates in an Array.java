class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> out = new ArrayList();
        HashSet<Integer> set = new HashSet();

        for(int n : nums) {
            if(set.contains(n)) out.add(n);
            set.add(n);
        }

        return out;
    }
}