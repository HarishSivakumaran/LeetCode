// 481. Magical String

class Solution {
    public int magicalString(int n) {
        if (n < 4)
            return 1;
        StringBuilder str = new StringBuilder("12");
        int i = 1;
        int out = 1;

        while (str.length() < n) {
            char last = str.charAt(str.length() - 1);
            char curr = str.charAt(i);
            if (curr == '2') {
                if (last == '1')
                    out++;
                str.append(last);
            }
            if (str.length() >= n)
                break;
            char end = getOther(last);
            if (end == '1')
                out++;
            str.append(end);
            i++;

        }

        return out;

    }

    public char getOther(char a) {
        return a == '1' ? '2' : '1';
    }
}