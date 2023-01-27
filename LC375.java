// 375. Guess Number Higher or Lower II

class Solution {
    public int getMoneyAmount(int n) {
        Integer[][] lookup = new Integer[n+1][n+1];
        return  minAmount(1, n, lookup);      
    }

    public int minAmount(int s, int e, Integer[][] lookup ){
        if(s >= e) return 0;

        if( lookup[s][e] != null ) return lookup[s][e];

        int res = Integer.MAX_VALUE;
        for(int i = s; i <=e; i++){
            res = Math.min(res, i + Math.max(minAmount(s, i-1, lookup), minAmount(i+1, e, lookup)));
        }

        lookup[s][e] = res;

        return res;


    }
}

