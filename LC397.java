// 397. Integer Replacement

class Solution {
    public int integerReplacement(int n) {
        HashMap<Long,Integer> dp = new HashMap();
        return getMinReplacement((long)n, dp);      
    }

    public int getMinReplacement(long n, HashMap<Long,Integer> dp){
        if(n == 1) return 0;

        if(dp.containsKey(n)) return dp.get(n);

        if(n % 2 == 0){
            dp.put(n , 1 + getMinReplacement(n/2, dp));
        }else{
            dp.put(n, 1 + Math.min(getMinReplacement(n+1, dp), getMinReplacement(n-1, dp)));
        }

        return dp.get(n);      

    }
}