// 448. Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // HashSet<Integer> hs = new HashSet();

        // for(int n : nums){
        // hs.add(n);
        // }

        List<Integer> out = new ArrayList();

        for (int n : nums) {
            int i = Math.abs(n);
            if (nums[i - 1] > 0) {
                nums[i - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                out.add(i + 1);
        }

        // for(int i = 1; i <= nums.length; i++){
        // if(!hs.contains(i)) out.add(i);
        // }

        return out;

    }
}