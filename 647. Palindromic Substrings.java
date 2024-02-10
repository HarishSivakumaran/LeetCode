class Solution {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int i = 0, ans = 0;
        while(i < s.length()){
            ans += getPal(i, i, arr);
            ans += getPal(i, i+1, arr);
            i++;
        }

        return ans;
    }

    private int getPal(int l, int r, char[] arr) {
        int c = 0;
        while(l >= 0 && r < arr.length && arr[l] == arr[r]) {
            c++;
            l--;
            r++;
        }

        return c;
    }
}