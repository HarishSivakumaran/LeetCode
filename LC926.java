// 926. Flip String to Monotone Increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        int t = 0;

        //starting from left window as 0 length, right window as everything
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '0') t++;
        }


        int min = t;
        for(int i = 0; i < s.length();i++){ // left window pointer
            if(s.charAt(i) == '0'){
                t--;
                min = Math.min(min, t);
            }else{
                t++;
            }
        }

        return min;
        
    }
}