class Solution {
    public int bestClosingTime(String customers) {
        int minTime = 0, penalty = 0, currPen = 0;
        for(int i = 0; i < customers.length(); i++) {
            if(customers.charAt(i) == 'Y') {
                currPen--;
            } else {
                currPen++;
            }

            if(currPen < penalty) {
                penalty = currPen;
                minTime = i+1;
            }
        }

        return minTime;
    }
}