class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] insert = pairs[0];
        int toBeDel = 0;
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);

        for(int i = 1; i < pairs.length; i++) {
            // curr before insert (not possible since we have sorted)

            // merge
            if(insert[1] >= pairs[i][0] && insert[0] <= pairs[i][1]) {
                toBeDel++;
                if(pairs[i][1] < insert[1]) {
                    insert = pairs[i];
                }
                continue;
            }

            //insert before curr
            insert = pairs[i];
        }

        return pairs.length-toBeDel;
    }
}