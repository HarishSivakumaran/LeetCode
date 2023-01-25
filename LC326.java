// 326. Power of Three

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1) return false;
        
        return Math.pow(3,19)%n == 0;
    }
}