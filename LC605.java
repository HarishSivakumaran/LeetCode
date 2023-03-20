// 605. Can Place Flowers

class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        if(n == 0) return true;

        for(int i = 0; i < f.length; i++){
            if(f[i] == 1) continue;

            if(i-1 >= 0 && f[i-1] != 0){
                continue;
            }
            if(i+1 < f.length && f[i+1] != 0){
                continue;
            }

            f[i] = 1;
            n--;
            if(n == 0) return true;


        }

        return false;
    }
}