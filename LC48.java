// 48. Rotate Image

class Solution {
    public void rotate(int[][] m) {
        int l = 0, r = m.length - 1;

        while(l < r){
            int t = l, b = r;
            for( int i = 0; i < r-l; i++ ){
                int a = m[t][l+i];

                //BL -> TL
                m[t][l+i] = m[b-i][l];

                //BR-> BL
                m[b-i][l] = m[b][r-i];

                //TR -> BR

                m[b][r-i] = m[t+i][r];

                //Temp -> TR
                m[t+i][r] = a;


            }
                l++;
                r--;
        }
    }


}