class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet();
        for(int n : nums1) map.add(n);
        List<Integer> out = new ArrayList(Math.min(nums1.length, nums2.length));

        for(int n : nums2) {
            if(map.contains(n)) {
                out.add(n);
                map.remove(n);
            }
        }

        int[] o = new int[out.size()];
        for(int i = 0; i < o.length; i++) o[i] = out.get(i);

        return o; 
    }
}