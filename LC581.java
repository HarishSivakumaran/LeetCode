// 581. Shortest Unsorted Continuous Subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack();
        int l = nums.length - 1, r = 0;

        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 0 && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());

            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());

            stack.push(i);
        }

        return r - l > 0 ? r - l + 1 : 0;

        // int[] a = Arrays.copyOf(nums,nums.length);
        // Arrays.sort(a);
        // int l = 0, r = nums.length-1;

        // while(l < r){
        // if(nums[l] != a[l]) break;
        // l++;
        // }

        // while(l < r){
        // if(nums[r] != a[r]) break;
        // r--;
        // }

        // return l >= r ? 0 : r-l+1;
    }
}