class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //i1, i2
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            return nums1[a[0]]+nums2[a[1]] - (nums1[b[0]]+nums2[b[1]]);
        });

        for(int i = 0; i < nums1.length; i++){
            pq.add(new int[]{i, 0});
        }

        List<List<Integer>> out = new ArrayList();
        int[] curr = null;

        while(out.size() < k && pq.size() > 0){
            curr = pq.poll();
            out.add(List.of(nums1[curr[0]], nums2[curr[1]]));
            if(curr[1] < nums2.length-1){
                curr[1]++;
                pq.add(curr);
            }
        }

        return out;
    }
}