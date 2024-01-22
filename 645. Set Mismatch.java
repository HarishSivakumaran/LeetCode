class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int rep = -1;
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
            if(map.get(n) == 2) rep = n;
        }

        for(int i = 1; i <= nums.length; i++) {
            if(!map.containsKey(i)) return new int[]{rep, i};
        }

        return null;

    }
}