// 491. Non-decreasing Subsequences

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> out = new HashSet();
        findNonDSubs(nums, new ArrayList<Integer>(), 0, out);
        return new ArrayList(out);
    }

    public void findNonDSubs(int[] nums, List<Integer> list, int i, HashSet<List<Integer>> out){

        if(i >= nums.length){
            if(list.size() > 1) out.add(new ArrayList<Integer>(list));
            return;
        }

        if(list.size() == 0 || list.get(list.size()-1) <= nums[i] ){
            list.add(nums[i]);
            findNonDSubs(nums, list, i+1, out);
            list.remove(list.size()-1);
        }

        findNonDSubs(nums, list, i+1, out);
    }
}