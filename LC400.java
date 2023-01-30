// 400. Nth Digit

class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long range = 9;
        int start = 1;

        while(n > len*range){
            n -= len*range;
            len++;
            range *= 10;
            start *= 10;         
        }  

        start += (n-1)/len;
        String value = String.valueOf(start);

        return (int)(value.charAt((n-1)%len)-'0');

    }
}