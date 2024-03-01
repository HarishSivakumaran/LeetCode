class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] o = s.toCharArray();
        int l = 0;
        for(int i = 0; i < o.length; i++) {
            if(o[i] == '1') {
                o[l] = '1';
                if(l != i) o[i] = '0';
                l++;
            }
        }
        o[l-1] = '0';
        o[o.length-1] = '1';

        return new String(o);
    }
}