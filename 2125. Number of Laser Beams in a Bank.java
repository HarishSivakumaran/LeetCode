class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, curr = 0;
        int ans = 0;
        for(String b : bank) {
            curr = 0;
            for(int i = 0; i < b.length(); i++) {
                if(b.charAt(i) == '1') curr++;
            }

            ans += (prev*curr);

            if(curr != 0) prev = curr;
        }

        return ans;
    }
}