class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 2;
        while(n > 2) {
            a = a+b;
            a = a+b;
            b = a-b;
            a = a-b;
            n--;
        }

        return n == 2 ? b : a;
    }
}