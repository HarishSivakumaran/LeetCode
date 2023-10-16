class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList(1);
        prev.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList(i+1);
            for(int c = 0; c <= i; c++) {
                int tl = c-1 >= 0 ? prev.get(c-1) : 0;
                int t = c < i ? prev.get(c) : 0;
                curr.add(t+tl);
            }
            prev = curr;
        }

        return prev;
    }
}