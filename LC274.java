// 274. H-Index

class Solution {
    public int hIndex(int[] c) {
       Arrays.sort(c); //ascending 
       int h = 0 ;
       for(int i = 0; i < c.length; i++){
            h = Math.max(h, Math.min(c[i], c.length-i));
       }

       return h;

        
    }
}