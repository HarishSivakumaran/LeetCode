class Solution {
    public long maximumSumOfHeights(List<Integer> h) {
        // left min
        long[] left = new long[h.size()];
        Stack<Integer> stack  = new Stack();
        long curr = 0;
        stack.push(-1);
        for(int i = 0; i < h.size(); i++) {
            int prevMinIndex = i-1;
            while(stack.size() > 1 && h.get(prevMinIndex) > h.get(i)) {
                prevMinIndex = stack.pop();
            }
            stack.push(prevMinIndex);
            curr = (prevMinIndex >= 0 ? left[prevMinIndex] : 0) +
                     (long)h.get(i)*(i-prevMinIndex);
            left[i] = curr;
        }

        stack.clear();
        stack.push(-1);
        curr = 0;
        long[] right = new long[h.size()];
        long max = 0;
        
        for(int i = h.size()-1; i >= 0; i--) {
            int prevMinIndex = i+1;
            while(stack.size() > 1 && h.get(prevMinIndex) > h.get(i)) {
                prevMinIndex = stack.pop();
            }
            stack.push(prevMinIndex);
            curr = (prevMinIndex < h.size() ? right[prevMinIndex] : 0) +
                     (long)h.get(i)*(prevMinIndex-i);
            right[i] = curr;
            max = Math.max(max, left[i]+right[i]-h.get(i));
        }

        return max;

        
    }
}