class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length)
            return nums;
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        while (i < k) {
            while (dq.size() > 0 && dq.peekLast() < nums[i])
                dq.pollLast();
            dq.addLast(nums[i++]);
        }

        int l = 0;
        int[] out = new int[nums.length + 1 - k];
        out[l] = dq.peekFirst();

        for (; i < nums.length; i++) {
            if (nums[l++] == dq.peekFirst())
                dq.pollFirst();
            while (dq.size() > 0 && dq.peekLast() < nums[i])
                dq.pollLast();
            dq.addLast(nums[i]);
            out[l] = dq.peekFirst();

        }
        return out;

    }
}