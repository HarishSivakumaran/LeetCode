// 875. Koko Eating Bananas

class Solution {
    int max = -1;
    public int minEatingSpeed(int[] piles, int h) {
          for(int i : piles){
             max = Math.max(max,i);}
          
        return binarySearch(piles, 1, max, h);
    }

    public int binarySearch(int[] p, int l, int r, int h){
        if(l >= r)
         return l;

        int m = (l+r)/2;

        if(checkIfSuits(p, h, m)){
          return binarySearch(p, l, m, h);
        }else{
          return binarySearch(p, m + 1, r, h);
        } 


    }  

    public boolean checkIfSuits(int[] piles, int h, int k){
        for(int p : piles){
            if(h <= 0)
             return false;
            
            int  t = p/k;
            if(p%k > 0){
                t++;
            }

            h -=t;
        }

        return h >= 0;

    }

}
