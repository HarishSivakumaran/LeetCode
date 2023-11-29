class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet();
        char[] arr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int l = 0, r = 0, req = (int)Math.pow(2,k);
        while(r < arr.length) {
            str.append(arr[r]);
            if(r-l+1 == k) {
                set.add(str.toString());
                str.deleteCharAt(0);
                l++;
            }
            r++;
            if(set.size() == req) return true;
        }

        return false;
    }
}