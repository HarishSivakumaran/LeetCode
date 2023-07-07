class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tCount = 0, fCount = 0, maxF = 0, l = 0, r = 0, ans = 0;

        while(r < answerKey.length()){
            char curr = answerKey.charAt(r);
            if(curr == 'T'){
                tCount++;
            }else{
                fCount++;
            }

            maxF = Math.max(maxF, Math.max(fCount, tCount));
            if(r-l+1 - maxF > k ){
                char left = answerKey.charAt(l++);
                if(left == 'T'){
                    tCount--;
                }else{
                    fCount--;
                }
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }
}