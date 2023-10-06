class Solution {
    public int integerBreak(int n) {
        int prev = Integer.MIN_VALUE, curr = 0;
        for(int i = 1; i < n; i++) {
            int t = n;
            curr = 0;
            int prevProd = i;
            while(t-i > 0) {
                curr = Math.max(curr, (t-i)*prevProd);
                prevProd *= i;
                t -= i;
                
            }
            if(curr < prev) return prev;
            prev = curr;
        }

        return curr;
    }
}