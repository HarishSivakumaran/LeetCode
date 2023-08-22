class Solution {
    public String convertToTitle(int num) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        while(num > 0) {
                count = num;
                if(count > 26) {
                    count = count%26;
                    count = count == 0? 26 : count;
                }
                str.append((char)('A'+count-1));
                num -= count;
                num /= 26;
        }

        return str.reverse().toString();
    }
}