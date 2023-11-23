class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
         List<Boolean> out = new ArrayList();
         for(int i = 0; i < l.length; i++) {
             if(r[i]-l[i]+1 < 2) {
                 out.add(false);
                 continue;
             }

             PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
             for(int j = l[i]; j <= r[i]; j++) {
                 pq.add(nums[j]);
             }
             
             int f = pq.poll(), s = pq.poll();
             int diff = s-f;
             boolean ans = true;
             while(pq.size() > 0) {
                 f = s;
                 s = pq.poll();
                 if(s-f != diff) {
                     ans = (false);
                     break;
                 }
             }

             out.add(ans);
         }

         return out;
    }
}