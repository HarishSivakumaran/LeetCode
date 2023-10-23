class Solution {
    public boolean isPowerOfFour(int n) {
        double pow = (double)Math.log(n)/Math.log(4);
        return pow%1 == 0.0;
    }
}