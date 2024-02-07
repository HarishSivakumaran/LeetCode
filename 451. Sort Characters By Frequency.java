class Solution {
    public String frequencySort(String s) {
        int[][] count = new int[200][2];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'0'][0]++;
            count[s.charAt(i)-'0'][1] = (int)(s.charAt(i)-'0');
        }

        Arrays.sort(count, (a, b) -> b[0]-a[0]);

        StringBuilder str = new StringBuilder();
        for(int[] c : count) {
            if(c[0] == 0) return str.toString();
            while(c[0] > 0) {
                str.append((char)(c[1]+'0'));
                c[0]--;
            }
        }

        return str.toString();

    }
}