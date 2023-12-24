class Solution {
    public int minOperations(String s) {
        int swz = 0, swo = 0;
        for(int i = 0; i < s.length(); i++) {
            //swz
            if(((i&1) == 1 && s.charAt(i) != '1') || 
            ((i&1) == 0 && s.charAt(i) != '0')) swz++;

            //sw0
            if(((i&1) == 1 && s.charAt(i) != '0') || 
            ((i&1)== 0 && s.charAt(i) != '1')) swo++;
        }

        return Math.min(swz, swo);
    }
}