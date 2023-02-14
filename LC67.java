// 67. Add Binary

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int l = a.length() - 1, r = b.length() - 1, c = 0, a1 = 0, b1 = 0, s = 0;

        while (l >= 0 || r >= 0 || c != 0) {
            a1 = l >= 0 ? a.charAt(l) - '0' : 0;
            b1 = r >= 0 ? b.charAt(r) - '0' : 0;
            s = a1 ^ b1 ^ c;
            c = (a1 & b1) | (a1 & c) | (c & b1);
            str.append(s);
            l--;
            r--;
        }

        return str.reverse().toString();
    }
}