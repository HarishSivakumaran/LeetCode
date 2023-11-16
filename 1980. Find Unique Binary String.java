class Solution {
    HashSet<String> set = new HashSet();
    public String findDifferentBinaryString(String[] nums) {
        char[] out = new char[nums[0].length()];
        for(String s : nums) set.add(s);

        ways(0, out.length, out);

        return new String(out);
    }

    private boolean ways(int index, int n, char[] out) {
        if(index >= n) {
            return !set.contains(new String(out));
        }

        out[index] = '0';
        boolean found = ways(index+1, n, out);
        if(found) return true;

        out[index] = '1';
        found = ways(index+1, n, out);

        return found;
    }
}