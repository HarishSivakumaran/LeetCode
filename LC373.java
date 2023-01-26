// 373. Find K Pairs with Smallest Sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int r = nums1.length, c = nums2.length;
        List<List<Integer>> out = new ArrayList();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[2]-b[2]));
        for(int col = 0; col < c; col++)pq.add(new int[]{0, col, nums1[0]+nums2[col]});
        
        for(int i = 0; i < k && pq.size() > 0; i++){
            int[] curr = pq.poll();
            List<Integer> points = new ArrayList();
            points.add(nums1[curr[0]]);
            points.add(nums2[curr[1]]);
            out.add(points);
            if(curr[0] == r-1)continue;
            pq.add(new int[]{curr[0]+1, curr[1], nums1[curr[0]+1]+nums2[curr[1]]});

        }

        return out;
        
    }
}

