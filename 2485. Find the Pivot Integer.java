class Solution {
    public int pivotInteger(int n) {
        int total = ((n)*(n+1))/2;
       for(int i = 1; i <= n; i++) {
        int curr = (i*(i+1))/2;
            if(curr == (total-curr+i)) return i;
       }

       return -1; 
    }
}