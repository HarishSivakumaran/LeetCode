class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascals = new ArrayList();
        pascals.add(List.of(1));
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList();
            for(int j = 0; j <= i; j++) {
                int l = j-1 >= 0 ? pascals.get(i-1).get(j-1) : 0;
                int t = j <= i-1 ? pascals.get(i-1).get(j) : 0;
                row.add(l+t);
            }
            pascals.add(row);
        }

        return pascals;
    }
}