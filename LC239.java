// 239. Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k > nums.length) return nums;
        Deque<Integer> dq = new LinkedList<>();
        int[] out = new int[nums.length - k + 1];
        int i = 0;
        while(i < k){
            while(dq.size() > 0 && dq.peekLast() < nums[i]){
                dq.pollLast();
            }
            dq.offer(nums[i]);
            i++;
        }
        int o = 0;
        out[o] = dq.peekFirst();

        int l = 0, r = k-1;
        while(r < nums.length-1){
            int removed = nums[l];
            if(removed == dq.peekFirst()) dq.pollFirst();
            l++;
            r++;
            int added = nums[r];
            while(dq.size() > 0 && dq.peekLast() < added){
                dq.pollLast();
            }
            dq.offer(added); 
            o++;     
            out[o] = dq.peekFirst();
        }

        return out;
       
    }
}