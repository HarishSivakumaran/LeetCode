class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 0, r = maxSum;

        while(l <= r){
            int m = l + (r-l)/2;
            if(possible(n, index, maxSum, m)){
                l = m+1;
            }else{
                r = m-1;
            }
        }

        return r;
    }

    public boolean possible(int n, int index, int maxSum, int val) {
        // [0,1,2...val], [vl+1, val+2...n]

        int bLen = index-0+1, aLen = n-index-1;
        long beforeVal = 0, afterVal = 0;

        if(bLen >= val){
            beforeVal = ((long)val*(val+1))/2;
            beforeVal += (bLen-val);
        }else{
            beforeVal = (long)((long)val*(val+1))/2;
            int rem = val-bLen;
            beforeVal -= ((long)rem*(rem+1))/2;
        }
        if(val > 1)
            val--;

        if(aLen >= val){
            afterVal = (long)((long)val*(val+1))/2;
            afterVal += (aLen-val);
        }else{
            afterVal = (long)((long)val*(val+1))/2;
            int rem = val-aLen;
            afterVal -= ((long)rem*(rem+1))/2;
        }

        return (afterVal+beforeVal) <= maxSum;
    }
}